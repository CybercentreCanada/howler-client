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
public class ElfModel implements GeneratedModel {
  String architecture;
  String byteOrder;
  String cpuType;
  String creationDate;
  List<String> exports;
  HeaderModel header;
  List<String> imports;
  List<SectionModel> sections;
  List<SegmentModel> segments;
  List<String> sharedLibraries;
  String telfhash;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("architecture", architecture, "String"),
      new Field("byte_order", byteOrder, "String"),
      new Field("cpu_type", cpuType, "String"),
      new Field("creation_date", creationDate, "String"),
      new Field("exports", exports, "List<String>"),
      new Field("header", header != null ? header.getFields() : null, "Class"),
      new Field("imports", imports, "List<String>"),
      new Field("sections", sections, "List<Class>"),
      new Field("segments", segments, "List<Class>"),
      new Field("shared_libraries", sharedLibraries, "List<String>"),
      new Field("telfhash", telfhash, "String")
    );
  }
}
