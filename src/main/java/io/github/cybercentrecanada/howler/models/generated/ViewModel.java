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
public class ViewModel implements GeneratedModel {
  String owner;
  String query;
  String title;
  String type;
  String viewId;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("owner", owner, "String"),
      new Field("query", query, "String"),
      new Field("title", title, "String"),
      new Field("type", type, "String"),
      new Field("view_id", viewId, "String")
    );
  }
}
