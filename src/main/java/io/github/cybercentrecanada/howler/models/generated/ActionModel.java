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
public class ActionModel implements GeneratedModel {
  String actionId;
  String name;
  List<OperationModel> operations;
  String query;
  List<String> triggers;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("action_id", actionId, "String"),
      new Field("name", name, "String"),
      new Field("operations", operations, "List<Class>"),
      new Field("query", query, "String"),
      new Field("triggers", triggers, "List<String>")
    );
  }
}
