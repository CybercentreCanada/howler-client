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
public class HitUserModel implements GeneratedModel {
  String domain;
  String email;
  String fullName;
  GroupModel group;
  String hash;
  String id;
  String name;
  List<String> roles;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("domain", domain, "String"),
      new Field("email", email, "String"),
      new Field("full_name", fullName, "String"),
      new Field("group", group != null ? group.getFields() : null, "Class"),
      new Field("hash", hash, "String"),
      new Field("id", id, "String"),
      new Field("name", name, "String"),
      new Field("roles", roles, "List<String>")
    );
  }
}
