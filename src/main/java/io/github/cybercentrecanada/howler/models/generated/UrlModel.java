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
public class UrlModel implements GeneratedModel {
  String domain;
  String extension;
  String fragment;
  String full;
  String original;
  String password;
  String path;
  Integer port;
  String query;
  String registeredDomain;
  String scheme;
  String subdomain;
  String topLevelDomain;
  String username;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("domain", domain, "String"),
      new Field("extension", extension, "String"),
      new Field("fragment", fragment, "String"),
      new Field("full", full, "String"),
      new Field("original", original, "String"),
      new Field("password", password, "String"),
      new Field("path", path, "String"),
      new Field("port", port, "Integer"),
      new Field("query", query, "String"),
      new Field("registered_domain", registeredDomain, "String"),
      new Field("scheme", scheme, "String"),
      new Field("subdomain", subdomain, "String"),
      new Field("top_level_domain", topLevelDomain, "String"),
      new Field("username", username, "String")
    );
  }
}
