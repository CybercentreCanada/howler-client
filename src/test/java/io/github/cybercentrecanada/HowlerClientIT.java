package io.github.cybercentrecanada.howler;

import io.github.cybercentrecanada.howler.exceptions.HowlerException;
import io.github.cybercentrecanada.howler.exceptions.HowlerRequestException;
import io.github.cybercentrecanada.howler.models.GroupedModel;
import io.github.cybercentrecanada.howler.models.HitValidationModel;
import io.github.cybercentrecanada.howler.models.generated.HitModel;
import io.github.cybercentrecanada.howler.models.generated.HowlerModel;
import io.github.cybercentrecanada.howler.requests.*;
import io.github.cybercentrecanada.howler.responses.hit.*;
import io.github.cybercentrecanada.howler.responses.search.*;
import com.google.common.base.Strings;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * Integration Test for Howler Client.
 */
public class HowlerClientIT {
    @Spy
    HowlerClient howlerClient = new HowlerClient();

    @Before
    public void init() {
        howlerClient.initializeApiKeyAuthentication();
        MockitoAnnotations.initMocks(this);
    }

    private String getId(HowlerClient howlerClient) {
        List<HitModel> models = howlerClient.searchHits(SearchOptions.builder().query("*:*").rows(1).build())
                .getApiResponse().getItems();

        if (models.isEmpty()) {
            return null;
        } else {
            return models.get(0).getHowler().getId();
        }
    }

    private HitModel getValidHit() {
        HitModel newHit = new HitModel();

        HowlerModel howlerData = new HowlerModel();
        howlerData.setAssignment("user");
        howlerData.setId(UUID.randomUUID().toString());
        howlerData.setAnalytic("An analytic");
        howlerData.setHash(DigestUtils.sha256Hex(UUID.randomUUID().toString()));
        howlerData.setScore(0.8);

        newHit.setHowler(howlerData);

        return newHit;
    }

    private HitModel getInvalidHit() {
        HitModel invalidHit = new HitModel();
        HowlerModel howler = new HowlerModel();
        howler.setId("invalid_hit");
        invalidHit.setHowler(howler);

        return invalidHit;
    }

    @Test
    public void testTestCreateValidHits() {
        HitModel validHit = getValidHit();
        CreateHitsResponse response = howlerClient.createHits(List.of(validHit, getValidHit()));

        Assert.assertEquals(201, response.getApiStatusCode());
        Assert.assertEquals(2, response.getApiResponse().getValid().size());
        for (HitModel hit : response.getApiResponse().getValid()) {
            GetHitResponse hitResponse = howlerClient.getHit(hit.getHowler().getId());
            Assert.assertEquals(200, hitResponse.getApiStatusCode());
            Assert.assertNotNull(hitResponse.getApiResponse());
        }
    }

    @Test
    public void testTestCreateInvalidHits() {
        HitModel validHit = getValidHit();
        HitModel invalidHit = getInvalidHit();

        Assert.assertThrows(HowlerRequestException.class, () -> {
            CreateHitsResponse response = howlerClient.createHits(List.of(validHit, invalidHit));
        });
    }

    @Test
    public void testDeleteHits() {
        HitModel validHit = getValidHit();

        CreateHitsResponse response = howlerClient.createHits(List.of(validHit));
        Assert.assertEquals(201, response.getApiStatusCode());
        Assert.assertEquals(1, response.getApiResponse().getValid().size());

        howlerClient.deleteHits(List.of(validHit.getHowler().getId()));
        Assert.assertThrows(HowlerException.class, () -> howlerClient.getHit(validHit.getHowler().getId()));
    }

    @Test
    public void testValidateHits() {
        ValidateHitsResponse response = howlerClient
                .validateHits(List.of(getValidHit(), getValidHit(), getInvalidHit()));

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertNotNull(response.getApiResponse());

        HitValidationModel data = response.getApiResponse();

        Assert.assertEquals(2, data.getValid().size());
        Assert.assertEquals(1, data.getInvalid().size());
    }

    @Test
    public void testGetHit() {
        String hitId = getId(howlerClient);

        HitModel hit = howlerClient.getHit(hitId).getApiResponse();
        Assert.assertNotNull(hit);
    }

    @Test
    public void testGetHits() {
        Mockito.when(howlerClient.setupHeaders()).thenReturn(new Header[] {
                new BasicHeader("Authorization",
                        "Basic " + Base64.getEncoder().encodeToString("user:devkey:user".getBytes())),
        });

        HitSearchResponse response = howlerClient.searchHits(SearchOptions.builder().query("*:*").build());
        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertFalse(response.getApiResponse().getItems().isEmpty());

        Mockito.reset(howlerClient);
    }

    @Test
    public void testGetHitsWithSearchOptions() {
        Mockito.when(howlerClient.setupHeaders()).thenReturn(new Header[] {
                new BasicHeader("Authorization",
                        "Basic " + Base64.getEncoder().encodeToString("user:devkey:user".getBytes())),
        });

        SearchOptions options = SearchOptions.builder()
                .query("*:*")
                .fields(List.of("howler.id", "howler.hash"))
                .rows(1)
                .offset(0)
                .build();

        HitSearchResponse response = howlerClient.searchHits(options);

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertFalse(response.getApiResponse().getItems().isEmpty());
        Assert.assertEquals(1, response.getApiResponse().getItems().size());

        HitModel firstModel = response.getApiResponse().getItems().get(0);
        Assert.assertNotNull(firstModel.getHowler().getHash());

        options.setOffset(1);
        options.setFields(List.of("howler.id"));

        response = howlerClient.searchHits(options);

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertFalse(response.getApiResponse().getItems().isEmpty());
        Assert.assertEquals(1, response.getApiResponse().getItems().size());

        HitModel secondModel = response.getApiResponse().getItems().get(0);
        Assert.assertNull(secondModel.getHowler().getHash());

        Assert.assertNotEquals(firstModel.getHowler().getId(), secondModel.getHowler().getId());

        Mockito.reset(howlerClient);
    }

    @Test
    public void testSearchHits() {
        SearchOptions options = SearchOptions.builder()
                .query("howler.analytic:*a*")
                .offset(0)
                .rows(3)
                .sort("howler.analytic asc")
                .timeout(10000)
                .build();

        HitSearchResponse response = howlerClient.searchHits(options);

        int originalAmount = response.getApiResponse().getTotal();

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertEquals(3, response.getApiResponse().getItems().size());

        options.setSort(null);
        options.setQuery("-_exists_:dns.id");

        response = howlerClient.searchHits(options);

        Assert.assertEquals(200, response.getApiStatusCode());
        for (HitModel model : response.getApiResponse().getItems()) {
            Assert.assertNull(model.getDns());
        }

        options.setQuery("howler.analytic:*a*");
        options.setFilters(List.of("_exists_:agent.id"));

        response = howlerClient.searchHits(options);

        Assert.assertTrue(response.getApiResponse().getTotal() <= originalAmount);

        options.setFields(List.of("howler.id"));

        response = howlerClient.searchHits(options);

        Assert.assertNull(response.getApiResponse().getItems().get(0).getHowler().getHash());
    }

    @Test
    public void testGroupSearchHits() {
        GroupSearchOptions options = GroupSearchOptions.builder()
                .groupSort("dns.id asc")
                .limit(4)
                .query("_exists_:dns.id")
                .filters(List.of("_exists_:agent.id", "_exists_:howler.hash"))
                .offset(2)
                .rows(2)
                .sort("howler.id asc")
                .fields(List.of("howler.id", "dns.id", "howler.status", "agent.id", "howler.hash"))
                .build();

        GroupedHitSearchResponse response = howlerClient.groupSearchHits("dns.id", options);

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertEquals(2, response.getApiResponse().getItems().size());

        for (GroupedModel<HitModel> hits : response.getApiResponse().getItems()) {
            for (HitModel hit : hits.getItems()) {
                Assert.assertNotNull(hit.getAgent().getId());
                Assert.assertNotNull(hit.getHowler().getHash());
            }
        }

        options.setRows(null);
        options.setOffset(null);
        options.setFields(null);

        response = howlerClient.groupSearchHits("howler.status", options);

        Assert.assertEquals(200, response.getApiStatusCode());

        for (GroupedModel<HitModel> hits : response.getApiResponse().getItems()) {
            Assert.assertTrue(hits.getItems().size() <= 4);
        }

        options.setLimit(10000);

        response = howlerClient.groupSearchHits("howler.status", options);

        Assert.assertEquals(200, response.getApiStatusCode());

        for (GroupedModel<HitModel> hits : response.getApiResponse().getItems()) {
            Assert.assertEquals((int) hits.getTotal(), hits.getItems().size());
        }
    }

    @Test
    public void testGetFields() {
        IndexFieldResponse response = howlerClient.getFields("hit");

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertFalse(response.getApiResponse().isEmpty());
    }

    @Test
    public void testFacetHits() {
        FacetOptions options = FacetOptions.builder()
                .mincount(5)
                .query("howler.id:*a*")
                .filters(List.of("_exists_:agent.id"))
                .build();

        FacetResponse response = howlerClient.facetHits("howler.status", options);
        int previousAmount = response.getApiResponse().size();

        Assert.assertEquals(200, response.getApiStatusCode());
        for (int value : response.getApiResponse().values()) {
            Assert.assertTrue(value >= 5);
        }

        options.setMincount(null);
        options.setQuery(null);
        options.setFilters(null);

        response = howlerClient.facetHits("howler.status", options);

        Assert.assertTrue(response.getApiResponse().size() >= previousAmount);
    }

    @Test
    public void testHistogramHits() {
        HistogramOptions options = HistogramOptions.builder()
                .start(0)
                .end(10000)
                .gap(1000)
                .query("howler.score:*")
                .mincount(5)
                .build();

        HistogramResponse response = howlerClient.histogramHits("event.duration", options);

        Assert.assertEquals(200, response.getApiStatusCode());
        for (int bucketSize : response.getApiResponse().values()) {
            Assert.assertTrue(bucketSize >= 5);
        }

        options.setGap(100);
        options.setMincount(null);

        response = howlerClient.histogramHits("event.duration", options);

        Assert.assertEquals(200, response.getApiStatusCode());
    }

    @Test
    public void testHitStats() {
        StatsOptions options = StatsOptions.builder()
                .query("event.duration:[1000 TO *]")
                .filters(List.of("_exists_:event.duration"))
                .build();

        StatsResponse response = howlerClient.hitStats("event.duration", options);

        Assert.assertEquals(200, response.getApiStatusCode());
        Assert.assertTrue(response.getApiResponse().getMin() < response.getApiResponse().getMax());
        float avg = (float) response.getApiResponse().getSum() / response.getApiResponse().getCount();
        Assert.assertTrue(
                List.of((int) Math.floor(avg), (int) Math.ceil(avg)).contains(response.getApiResponse().getAvg()));
        int firstAvg = response.getApiResponse().getAvg();

        options.setQuery("event.duration:*");

        response = howlerClient.hitStats("event.duration", options);

        Assert.assertTrue(response.getApiResponse().getAvg() < firstAvg);
    }
}
