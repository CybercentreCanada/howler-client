package cccs.hogwarts.howler;

import cccs.hogwarts.howler.exceptions.HowlerException;
import cccs.hogwarts.howler.models.generated.HitModel;
import cccs.hogwarts.howler.requests.*;
import cccs.hogwarts.howler.responses.hit.*;
import cccs.hogwarts.howler.responses.search.*;
import cccs.hogwarts.vault.VaultClient;
import cccs.hogwarts.vault.clients.basic.BasicVaultClient;
import cccs.hogwarts.vault.shared.ContextualRefreshToken;
import cccs.hogwarts.vault.utils.TokenUtils;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import java.util.Base64;
import java.util.List;

import static cccs.hogwarts.howler.HowlerUtils.defaultStringValue;

@Slf4j
public class HowlerClient implements Howler {
    // TODO: Update this
    protected static final String DEFAULT_HOWLER_URL = "http://localhost:5000";
    protected static final String DEFAULT_VAULT_URL = "http://localhost:8200";

    protected static final String DEFAULT_USER_NAME = "user";
    protected static final String DEFAULT_API_KEY = "devkey:user";

    // Env vars
    private static final String ENV_HOWLER_URL = "HOWLER_URL";
    private static final String ENV_USER_NAME = "HOWLER_USERNAME";
    private static final String ENV_API_KEY = "HOWLER_API_KEY";
    protected HowlerRestHandler restHandler;

    private String userName;
    private String apiKey;

    private VaultClient vaultClient;
    private String refreshClientName;
    private String accessToken;

    private String oboToken = "";

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

    @SuppressWarnings("unused")
    public HowlerClient initializeOboAuthentication() {
        return initializeOboAuthentication(null, null);
    }

    public HowlerClient initializeOboAuthentication(String accessToken, String clientName) {
        return initializeOboAuthentication(accessToken, clientName, null);
    }

    public HowlerClient initializeOboAuthentication(String accessToken, String clientName, String vaultUrl) {
        vaultClient = new BasicVaultClient(vaultUrl);

        if (!Strings.isNullOrEmpty(accessToken) && !Strings.isNullOrEmpty(clientName)) {
            this.accessToken = accessToken;
            this.refreshClientName = clientName;
        } else {
            ContextualRefreshToken ctxRefreshToken = new ContextualRefreshToken();
            String refreshToken = ctxRefreshToken.getRefreshToken();
            this.refreshClientName = ctxRefreshToken.getRefreshClientName();
            this.accessToken = vaultClient.refreshToken(refreshToken, this.refreshClientName).getAccessToken();
        }

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
        } else if (vaultClient != null && accessToken != null) {
            log.debug("Using OBO for authentication");

            if (Strings.isNullOrEmpty(this.oboToken) || TokenUtils.isTokenExpired(this.oboToken, 0)) {
                log.debug("OBO Token is expired or unset, get a new one");
                this.oboToken = vaultClient.getTokensOnBehalfOf("howler", refreshClientName, accessToken)
                        .getAccessToken();
            } else {
                log.debug("OBO Token is valid");
            }

            return new Header[] {
                    new BasicHeader("Authorization", String.format("Bearer %s", this.oboToken)) // TODO
            };
        } else {
            throw new HowlerException(
                    "Authentication not initialized! Call either initializeApiKeyAuthentication or initializeOBOAuthentication.");
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
