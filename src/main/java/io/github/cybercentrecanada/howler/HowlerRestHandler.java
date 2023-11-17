package io.github.cybercentrecanada.howler;

import io.github.cybercentrecanada.howler.exceptions.HowlerException;
import io.github.cybercentrecanada.howler.exceptions.HowlerRequestException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HowlerRestHandler {
    private static final Logger log = LoggerFactory.getLogger(HowlerRestHandler.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);

    private final String HOWLER_URL;

    private final String HOWLER_API_URL;

    private final String API_PATH = "/api/v1";

    public HowlerRestHandler(String url) {
        HOWLER_URL = url;
        HOWLER_API_URL = HOWLER_URL + API_PATH;
    }

    public String howlerUrlBuilder(String path) {
        return HOWLER_API_URL + path;
    }

    public static <T> T futureGet(CompletableFuture<T> future) throws HowlerException {
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            if (e.getCause() instanceof HowlerRequestException) {
                throw (HowlerRequestException) e.getCause();
            } else if (e.getCause() instanceof HowlerException) {
                throw (HowlerException) e.getCause();
            }

            throw new HowlerException(
                    String.format("Error occurred while sending your request to the Howler api: %s", e.getMessage()),
                    e);
        }
    }

    public <T> T request(String method, String path, Class<T> responseClass, Header[] headers, Object body,
            Map<String, String> parameters) throws HowlerException {
        return futureGet(requestAsync(method, path, responseClass, headers, body, parameters));
    }

    public <T> CompletableFuture<T> requestAsync(String method, String path, Class<T> responseClass,
            Header[] headers, Object body, Map<String, String> parameters) {
        return CompletableFuture.supplyAsync(() -> {
            try (CloseableHttpClient httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy())
                    .build()) {
                String url = howlerUrlBuilder(path);

                RequestBuilder requestBuilder = RequestBuilder.create(method).setUri(url);

                // Headers
                if (headers != null) {
                    Arrays.stream(headers).forEach(requestBuilder::addHeader);
                }

                if (parameters != null && !parameters.isEmpty()) {
                    parameters.forEach(requestBuilder::addParameter);
                }

                // Body
                if (body != null) {
                    requestBuilder.addHeader("Content-Type", "application/json");
                    requestBuilder.setEntity(new StringEntity(OBJECT_MAPPER.writeValueAsString(body)));
                }

                // Build request
                HttpUriRequest request = requestBuilder.build();
                log.debug(
                        String.format("Howler request for (%s, %s)", request.getMethod(), request.getURI().toString()));

                // ResponseHandler - take care of status codes and mapping response body to
                // Object class
                final ResponseHandler<T> responseHandler = response -> {
                    final int status = response.getStatusLine().getStatusCode();
                    log.debug(String.format("Howler response for (%s, %s): Status_code=%s, Reason: %s",
                            request.getMethod(), request.getURI().toString(), status,
                            response.getStatusLine().getReasonPhrase()));

                    if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_BAD_REQUEST) {

                        final HttpEntity entity = response.getEntity();
                        try {
                            if (entity == null || responseClass == null) {
                                log.debug("Howler response did not return any entities.");
                                return null;
                            }

                            final String responseBody = EntityUtils.toString(entity);
                            if (responseBody.isEmpty()) {
                                log.debug("Howler response returned an empty body.");
                                return null;
                            }
                            // Iterate over the api_warnings and log all the warnings
                            JsonNode jsonData = OBJECT_MAPPER.readTree(responseBody);
                            if (jsonData.has("api_warning")) {
                                jsonData.get("api_warning").iterator().forEachRemaining((n) -> log.warn(n.toString()));
                            }

                            return OBJECT_MAPPER.readValue(responseBody, responseClass);
                        } catch (final ParseException ex) {
                            throw new ClientProtocolException(ex);
                        }
                    } else {
                        throw new HowlerRequestException(status, EntityUtils.toString(response.getEntity()));
                    }
                };
                return httpClient.execute(request, responseHandler);
            } catch (UnsupportedOperationException | IOException e) {
                throw new HowlerException(String.format(
                        "Error occurred while sending your request to the Howler api: %s", e.getMessage()), e);
            }
        });
    }

    public <T> T get(String path, Class<T> klass) {
        return this.get(path, klass, null);
    }

    public <T> T get(String path, Class<T> klass, Header[] headers) {
        return this.get(path, klass, headers, null);
    }

    public <T> T get(String path, Class<T> klass, Header[] headers, Map<String, String> parameters) {
        return this.request("GET", path, klass, headers, null, parameters);
    }

    public <T> T post(String path, Object body, Class<T> klass, Header[] headers) {
        return this.post(path, body, klass, headers, null);
    }

    public <T> T post(String path, Object body, Class<T> klass, Header[] headers, Map<String, String> parameters) {
        return this.request("POST", path, klass, headers, body, parameters);
    }

    public <T> T put(String path, Object body, Class<T> klass, Header[] headers) {
        return this.put(path, body, klass, headers, null);
    }

    public <T> T put(String path, Object body, Class<T> klass, Header[] headers, Map<String, String> parameters) {
        return this.request("PUT", path, klass, headers, body, parameters);
    }

    public <T> T delete(String path) {
        return this.delete(path, null);
    }

    public <T> T delete(String path, Object body, Class<T> klass, Header[] headers) {
        return this.delete(path, body, klass, headers, null);
    }

    public <T> T delete(String path, Object body, Class<T> klass, Header[] headers, Map<String, String> parameters) {
        return this.request("DELETE", path, klass, headers, body, parameters);
    }

    public <T> T delete(String path, Header[] headers) {
        return this.delete(path, null, null, headers);
    }

    public <T> CompletableFuture<T> getAsync(String path, Class<T> klass) {
        return this.getAsync(path, klass, null, null);
    }

    public <T> CompletableFuture<T> getAsync(String path, Class<T> klass, Header[] headers,
            Map<String, String> parameters) {
        return this.requestAsync("GET", path, klass, headers, null, parameters);
    }

    public <T> CompletableFuture<T> postAsync(String path, Object body, Class<T> klass,
            Header[] headers, Map<String, String> parameters) {
        return this.requestAsync("POST", path, klass, headers, body, parameters);
    }

    public <T> CompletableFuture<T> putAsync(String path, Object body, Class<T> klass,
            Header[] headers, Map<String, String> parameters) {
        return this.requestAsync("PUT", path, klass, headers, body, parameters);
    }

    public <T> CompletableFuture<T> deleteAsync(String path) {
        return this.deleteAsync(path, null, null);
    }

    public <T> CompletableFuture<T> deleteAsync(String path, Header[] headers, Map<String, String> parameters) {
        return this.requestAsync("DELETE", path, null, headers, null, parameters);
    }
}
