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
public class PeModel implements GeneratedModel {
  String architecture;
  String company;
  String description;
  String fileVersion;
  String imphash;
  String originalFileName;
  String pehash;
  String product;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("architecture", architecture, "String"),
      new Field("company", company, "String"),
      new Field("description", description, "String"),
      new Field("file_version", fileVersion, "String"),
      new Field("imphash", imphash, "String"),
      new Field("original_file_name", originalFileName, "String"),
      new Field("pehash", pehash, "String"),
      new Field("product", product, "String")
    );
  }
}
