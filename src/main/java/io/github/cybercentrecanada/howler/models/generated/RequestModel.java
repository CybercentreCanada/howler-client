package io.github.cybercentrecanada.howler.models.generated;

import io.github.cybercentrecanada.howler.models.Field;
import io.github.cybercentrecanada.howler.models.GeneratedModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * NOTE: This is an auto-generated file. Don't edit this manually.
 */
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestModel implements GeneratedModel {
  BodyModel body;
  Integer bytes;
  String id;
  String method;
  String mimeType;
  String referrer;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("body", body != null ? body.getFields() : null, "Class"),
        new Field("bytes", bytes, "Integer"),
        new Field("id", id, "String"),
        new Field("method", method, "String"),
        new Field("mime_type", mimeType, "String"),
        new Field("referrer", referrer, "String"));
  }
}
