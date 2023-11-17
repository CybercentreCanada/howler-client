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
public class RegistryModel implements GeneratedModel {
  DataModel data;
  String hive;
  String key;
  String path;
  String value;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("data", data != null ? data.getFields() : null, "Class"),
      new Field("hive", hive, "String"),
      new Field("key", key, "String"),
      new Field("path", path, "String"),
      new Field("value", value, "String")
    );
  }
}
