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
public class GeoModel implements GeneratedModel {
  String cityName;
  String continentCode;
  String continentName;
  String countryIsoCode;
  String countryName;
  LocationModel location;
  String name;
  String postalCode;
  String regionIsoCode;
  String regionName;
  String timezone;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("city_name", cityName, "String"),
        new Field("continent_code", continentCode, "String"),
        new Field("continent_name", continentName, "String"),
        new Field("country_iso_code", countryIsoCode, "String"),
        new Field("country_name", countryName, "String"),
        new Field("location", location != null ? location.getFields() : null, "Class"),
        new Field("name", name, "String"),
        new Field("postal_code", postalCode, "String"),
        new Field("region_iso_code", regionIsoCode, "String"),
        new Field("region_name", regionName, "String"),
        new Field("timezone", timezone, "String"));
  }
}
