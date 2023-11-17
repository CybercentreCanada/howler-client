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
public class AnalyticModel implements GeneratedModel {
  String analyticId;
  List<AnalyticCommentModel> comment;
  String description;
  List<String> detections;
  String name;
  List<NotebookModel> notebooks;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("analytic_id", analyticId, "String"),
        new Field("comment", comment, "List<Class>"),
        new Field("description", description, "String"),
        new Field("detections", detections, "List<String>"),
        new Field("name", name, "String"),
        new Field("notebooks", notebooks, "List<Class>"));
  }
}
