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
public class FeedModel implements GeneratedModel {
  String dashboardId;
  String description;
  String name;
  String reference;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("dashboard_id", dashboardId, "String"),
      new Field("description", description, "String"),
      new Field("name", name, "String"),
      new Field("reference", reference, "String")
    );
  }
}
