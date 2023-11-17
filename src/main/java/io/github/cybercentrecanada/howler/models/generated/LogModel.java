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
public class LogModel implements GeneratedModel {
  String explanation;
  String key;
  String newValue;
  String previousValue;
  String previousVersion;
  String timestamp;
  String type;
  String user;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("explanation", explanation, "String"),
        new Field("key", key, "String"),
        new Field("new_value", newValue, "String"),
        new Field("previous_value", previousValue, "String"),
        new Field("previous_version", previousVersion, "String"),
        new Field("timestamp", timestamp, "String"),
        new Field("type", type, "String"),
        new Field("user", user, "String"));
  }
}
