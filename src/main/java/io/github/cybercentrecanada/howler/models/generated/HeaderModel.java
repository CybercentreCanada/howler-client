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
public class HeaderModel implements GeneratedModel {
  String abiVersion;
  @JsonProperty("class")
  String klass;
  String data;
  Integer entrypoint;
  String objectVersion;
  String osAbi;
  String type;
  String version;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("abi_version", abiVersion, "String"),
        new Field("class", klass, "String"),
        new Field("data", data, "String"),
        new Field("entrypoint", entrypoint, "Integer"),
        new Field("object_version", objectVersion, "String"),
        new Field("os_abi", osAbi, "String"),
        new Field("type", type, "String"),
        new Field("version", version, "String"));
  }
}
