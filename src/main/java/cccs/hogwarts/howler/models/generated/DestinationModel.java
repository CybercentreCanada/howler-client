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
public class DestinationModel implements GeneratedModel {
  String address;
  Integer bytes;
  String domain;
  GeoModel geo;
  String ip;
  String mac;
  NatModel nat;
  Integer packets;
  Integer port;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("address", address, "String"),
      new Field("bytes", bytes, "Integer"),
      new Field("domain", domain, "String"),
      new Field("geo", geo != null ? geo.getFields() : null, "Class"),
      new Field("ip", ip, "String"),
      new Field("mac", mac, "String"),
      new Field("nat", nat != null ? nat.getFields() : null, "Class"),
      new Field("packets", packets, "Integer"),
      new Field("port", port, "Integer")
    );
  }
}
