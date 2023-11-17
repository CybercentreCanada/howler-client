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
public class FaasModel implements GeneratedModel {
  Boolean coldstart;
  String execution;
  String id;
  String name;
  TriggerModel trigger;
  String version;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("coldstart", coldstart, "Boolean"),
      new Field("execution", execution, "String"),
      new Field("id", id, "String"),
      new Field("name", name, "String"),
      new Field("trigger", trigger != null ? trigger.getFields() : null, "Class"),
      new Field("version", version, "String")
    );
  }
}
