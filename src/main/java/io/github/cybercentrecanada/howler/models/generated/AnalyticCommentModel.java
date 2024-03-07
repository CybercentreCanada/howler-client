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
public class AnalyticCommentModel implements GeneratedModel {
  String detection;
  String id;
  String modified;
  Map<String, String> reactions;
  String timestamp;
  String user;
  String value;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("detection", detection, "String"),
      new Field("id", id, "String"),
      new Field("modified", modified, "String"),
      new Field("reactions", reactions, "Map<String, String>"),
      new Field("timestamp", timestamp, "String"),
      new Field("user", user, "String"),
      new Field("value", value, "String")
    );
  }
}