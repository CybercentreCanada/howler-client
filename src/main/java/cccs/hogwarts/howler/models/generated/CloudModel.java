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
public class CloudModel implements GeneratedModel {
  CloudAccountModel account;
  String availabilityZone;
  InstanceModel instance;
  MachineModel machine;
  ProjectModel project;
  String provider;
  String region;
  ServiceModel service;
  String tenantId;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("account", account != null ? account.getFields() : null, "Class"),
      new Field("availability_zone", availabilityZone, "String"),
      new Field("instance", instance != null ? instance.getFields() : null, "Class"),
      new Field("machine", machine != null ? machine.getFields() : null, "Class"),
      new Field("project", project != null ? project.getFields() : null, "Class"),
      new Field("provider", provider, "String"),
      new Field("region", region, "String"),
      new Field("service", service != null ? service.getFields() : null, "Class"),
      new Field("tenant_id", tenantId, "String")
    );
  }
}
