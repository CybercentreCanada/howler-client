package io.github.cybercentrecanada.howler;

import static io.github.cybercentrecanada.howler.HowlerUtils.defaultStringValue;

import io.github.cybercentrecanada.howler.exceptions.HowlerException;
import io.github.cybercentrecanada.howler.models.generated.HitModel;
import io.github.cybercentrecanada.howler.requests.FacetOptions;
import io.github.cybercentrecanada.howler.requests.GroupSearchOptions;
import io.github.cybercentrecanada.howler.requests.HistogramOptions;
import io.github.cybercentrecanada.howler.requests.SearchOptions;
import io.github.cybercentrecanada.howler.requests.StatsOptions;
import io.github.cybercentrecanada.howler.responses.hit.CreateHitsResponse;
import io.github.cybercentrecanada.howler.responses.hit.DeleteHitsResponse;
import io.github.cybercentrecanada.howler.responses.hit.GetHitResponse;
import io.github.cybercentrecanada.howler.responses.hit.ValidateHitsResponse;
import io.github.cybercentrecanada.howler.responses.search.FacetResponse;
import io.github.cybercentrecanada.howler.responses.search.GroupedHitSearchResponse;
import io.github.cybercentrecanada.howler.responses.search.HistogramResponse;
import io.github.cybercentrecanada.howler.responses.search.HitSearchResponse;
import io.github.cybercentrecanada.howler.responses.search.IndexFieldResponse;
import io.github.cybercentrecanada.howler.responses.search.StatsResponse;
import com.google.common.base.Strings;
import java.util.Base64;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

@Slf4j
public class HowlerClient implements Howler {
    // TODO: Update this
    protected static final String DEFAULT_HOWLER_URL = "http://localhost:5000";

    protected static final String DEFAULT_USER_NAME = "user";
    protected static final String DEFAULT_API_KEY = "devkey:user";

    // Env vars
    private static final String ENV_HOWLER_URL = "HOWLER_URL";
    private static final String ENV_USER_NAME = "HOWLER_USERNAME";
    private static final String ENV_API_KEY = "HOWLER_API_KEY";
    protected HowlerRestHandler restHandler;

    private String userName;
    private String apiKey;

    public HowlerClient() {
        this((String) null);
    }

    public HowlerClient(String url) {
        restHandler = new HowlerRestHandler(defaultStringValue(url, ENV_HOWLER_URL, DEFAULT_HOWLER_URL));
    }

    @SuppressWarnings("unused")
    public HowlerClient(HowlerRestHandler handler) {
        restHandler = handler;
    }

    public HowlerClient initializeApiKeyAuthentication() {
        return initializeApiKeyAuthentication(null, null);
    }

    public HowlerClient initializeApiKeyAuthentication(String userName, String apiKey) {
        this.userName = defaultStringValue(userName, ENV_USER_NAME, DEFAULT_USER_NAME);
        this.apiKey = defaultStringValue(apiKey, ENV_API_KEY, DEFAULT_API_KEY);

        return this;
    }

    protected Header[] setupHeaders() {
        if (!Strings.isNullOrEmpty(userName) && !Strings.isNullOrEmpty(apiKey)) {
            log.debug("Using user/apikey pair for authentication");

            return new Header[] {

                    new BasicHeader("Authorization",
                            "Basic " + Base64.getEncoder()
                                    .encodeToString(String.format("%s:%s", userName, apiKey).getBytes())),
            };
        } else {
            String errorMessage = "Authentication not initialized! Call initializeApiKeyAuthentication.";
            throw new HowlerException(errorMessage);
        }
    }

    @Override
    public CreateHitsResponse createHits(List<HitModel> hits) {
        return restHandler.post("/hit/", hits, CreateHitsResponse.class, setupHeaders());
    }

    @Override
    public DeleteHitsResponse deleteHits(List<String> hitIds) {
        return restHandler.delete("/hit/", hitIds, DeleteHitsResponse.class, setupHeaders());
    }

    @Override
    public ValidateHitsResponse validateHits(List<HitModel> hits) {
        return restHandler.post("/hit/validate/", hits, ValidateHitsResponse.class, setupHeaders());
    }

    @Override
    public GetHitResponse getHit(String hitId) {
        return restHandler.get(String.format("/hit/%s/", hitId), GetHitResponse.class, setupHeaders());
    }

    @Override
    public HitSearchResponse searchHits(SearchOptions options) {
        return restHandler.post("/search/hit/", options, HitSearchResponse.class, setupHeaders());
    }

    @Override
    public GroupedHitSearchResponse groupSearchHits(String groupField, GroupSearchOptions options) {
        return restHandler.post(String.format("/search/grouped/hit/%s/", groupField), options,
                GroupedHitSearchResponse.class, setupHeaders());
    }

    @Override
    public IndexFieldResponse getFields(String index) {
        return restHandler.get(String.format("/search/fields/%s/", index), IndexFieldResponse.class, setupHeaders());
    }

    @Override
    public FacetResponse facetHits(String field, FacetOptions options) {
        return facet("hit", field, options);
    }

    @Override
    public FacetResponse facet(String index, String field, FacetOptions options) {
        return restHandler.post(String.format("/search/facet/%s/%s/", index, field), options, FacetResponse.class,
                setupHeaders());
    }

    @Override
    public HistogramResponse histogramHits(String field, HistogramOptions options) {
        return histogram("hit", field, options);
    }

    @Override
    public HistogramResponse histogram(String index, String field, HistogramOptions options) {
        return restHandler.post(String.format("/search/histogram/%s/%s/", index, field), options,
                HistogramResponse.class, setupHeaders());
    }

    @Override
    public StatsResponse hitStats(String intField, StatsOptions options) {
        return stats("hit", intField, options);
    }

    @Override
    public StatsResponse stats(String index, String intField, StatsOptions options) {
        return restHandler.post(String.format("/search/stats/%s/%s/", index, intField), options, StatsResponse.class,
                setupHeaders());
    }
}
