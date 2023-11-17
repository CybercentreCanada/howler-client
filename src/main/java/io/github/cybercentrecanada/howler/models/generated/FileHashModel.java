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
public class FileHashModel implements GeneratedModel {
  String md5;
  String sha1;
  String sha256;
  String sha384;
  String sha512;
  String ssdeep;
  String tlsh;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("md5", md5, "String"),
        new Field("sha1", sha1, "String"),
        new Field("sha256", sha256, "String"),
        new Field("sha384", sha384, "String"),
        new Field("sha512", sha512, "String"),
        new Field("ssdeep", ssdeep, "String"),
        new Field("tlsh", tlsh, "String"));
  }
}
