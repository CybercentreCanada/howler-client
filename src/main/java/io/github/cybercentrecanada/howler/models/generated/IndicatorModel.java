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
public class IndicatorModel implements GeneratedModel {
  String confidence;
  String description;
  IndicatorEmailModel email;
  String firstSeen;
  String ip;
  String lastSeen;
  String provider;
  String reference;
  Integer scannerStats;
  Integer sightings;
  String type;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("confidence", confidence, "String"),
        new Field("description", description, "String"),
        new Field("email", email != null ? email.getFields() : null, "Class"),
        new Field("first_seen", firstSeen, "String"),
        new Field("ip", ip, "String"),
        new Field("last_seen", lastSeen, "String"),
        new Field("provider", provider, "String"),
        new Field("reference", reference, "String"),
        new Field("scanner_stats", scannerStats, "Integer"),
        new Field("sightings", sightings, "Integer"),
        new Field("type", type, "String"));
  }
}
