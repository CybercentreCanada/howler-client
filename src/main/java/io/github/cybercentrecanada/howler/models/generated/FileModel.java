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
public class FileModel implements GeneratedModel {
  String extension;
  FileHashModel hash;
  String mimeType;
  String name;
  Integer size;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("extension", extension, "String"),
      new Field("hash", hash != null ? hash.getFields() : null, "Class"),
      new Field("mime_type", mimeType, "String"),
      new Field("name", name, "String"),
      new Field("size", size, "Integer")
    );
  }
}
