package cccs.hogwarts.howler.models.generated;

import cccs.hogwarts.howler.models.Field;
import cccs.hogwarts.howler.models.GeneratedModel;
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
public class LabelsModel implements GeneratedModel {
  List<String> assignments;
  List<String> campaign;
  List<String> generic;
  List<String> insight;
  List<String> mitigation;
  List<String> operation;
  List<String> threat;
  List<String> victim;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("assignments", assignments, "List<String>"),
      new Field("campaign", campaign, "List<String>"),
      new Field("generic", generic, "List<String>"),
      new Field("insight", insight, "List<String>"),
      new Field("mitigation", mitigation, "List<String>"),
      new Field("operation", operation, "List<String>"),
      new Field("threat", threat, "List<String>"),
      new Field("victim", victim, "List<String>")
    );
  }
}
