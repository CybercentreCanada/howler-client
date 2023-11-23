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
public class RelatedModel implements GeneratedModel {
  List<String> hash;
  List<String> hosts;
  String id;
  List<String> ip;
  List<String> signature;
  List<String> uri;
  List<String> user;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("hash", hash, "List<String>"),
      new Field("hosts", hosts, "List<String>"),
      new Field("id", id, "String"),
      new Field("ip", ip, "List<String>"),
      new Field("signature", signature, "List<String>"),
      new Field("uri", uri, "List<String>"),
      new Field("user", user, "List<String>")
    );
  }
}
