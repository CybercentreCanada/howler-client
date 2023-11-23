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
public class TemplateModel implements GeneratedModel {
  String analytic;
  String detection;
  List<String> keys;
  String owner;
  String templateId;
  String type;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("analytic", analytic, "String"),
      new Field("detection", detection, "String"),
      new Field("keys", keys, "List<String>"),
      new Field("owner", owner, "String"),
      new Field("template_id", templateId, "String"),
      new Field("type", type, "String")
    );
  }
}
