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
public class UserUserModel implements GeneratedModel {
  Integer apiQuota;
  String classification;
  String email;
  List<String> favouriteViews;
  List<String> groups;
  Boolean isActive;
  String name;
  String password;
  List<String> type;
  String uname;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("api_quota", apiQuota, "Integer"),
      new Field("classification", classification, "String"),
      new Field("email", email, "String"),
      new Field("favourite_views", favouriteViews, "List<String>"),
      new Field("groups", groups, "List<String>"),
      new Field("is_active", isActive, "Boolean"),
      new Field("name", name, "String"),
      new Field("password", password, "String"),
      new Field("type", type, "List<String>"),
      new Field("uname", uname, "String")
    );
  }
}
