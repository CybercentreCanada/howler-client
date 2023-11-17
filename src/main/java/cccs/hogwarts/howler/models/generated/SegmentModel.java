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
public class SegmentModel implements GeneratedModel {
  Integer chi2;
  Integer entropy;
  String flags;
  String name;
  String physicalOffset;
  Integer physicalSize;
  String type;
  Integer virtualAddress;
  Integer virtualSize;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("chi2", chi2, "Integer"),
      new Field("entropy", entropy, "Integer"),
      new Field("flags", flags, "String"),
      new Field("name", name, "String"),
      new Field("physical_offset", physicalOffset, "String"),
      new Field("physical_size", physicalSize, "Integer"),
      new Field("type", type, "String"),
      new Field("virtual_address", virtualAddress, "Integer"),
      new Field("virtual_size", virtualSize, "Integer")
    );
  }
}
