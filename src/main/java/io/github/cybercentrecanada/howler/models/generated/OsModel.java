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
public class OsModel implements GeneratedModel {
  String family;
  String full;
  String kernel;
  String name;
  String platform;
  String type;
  String version;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("family", family, "String"),
        new Field("full", full, "String"),
        new Field("kernel", kernel, "String"),
        new Field("name", name, "String"),
        new Field("platform", platform, "String"),
        new Field("type", type, "String"),
        new Field("version", version, "String"));
  }
}
