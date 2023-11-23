package io.github.cybercentrecanada.howler;

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
import java.util.List;

public interface Howler {

    /**
     * Create hits.
     */
    CreateHitsResponse createHits(List<HitModel> hits);

    /**
     * Delete hits.
     */
    DeleteHitsResponse deleteHits(List<String> hitIds);

    /**
     * Submit a list of potential new hits for validation.
     */
    ValidateHitsResponse validateHits(List<HitModel> hits);

    /**
     * Get the hit associated with a given id.
     */
    GetHitResponse getHit(String hitId);

    /**
     * Search all hits.
     */
    HitSearchResponse searchHits(SearchOptions options);

    /**
     * Search hits, grouped by a particular field
     */
    GroupedHitSearchResponse groupSearchHits(String groupField, GroupSearchOptions options);

    IndexFieldResponse getFields(String index);

    FacetResponse facetHits(String field, FacetOptions options);

    FacetResponse facet(String index, String field, FacetOptions options);

    HistogramResponse histogramHits(String field, HistogramOptions options);

    HistogramResponse histogram(String index, String field, HistogramOptions options);

    StatsResponse hitStats(String intField, StatsOptions options);

    StatsResponse stats(String index, String intField, StatsOptions options);
}
