package cccs.hogwarts.howler;

import cccs.hogwarts.howler.models.generated.HitModel;
import cccs.hogwarts.howler.requests.*;
import cccs.hogwarts.howler.responses.hit.*;
import cccs.hogwarts.howler.responses.search.*;

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
