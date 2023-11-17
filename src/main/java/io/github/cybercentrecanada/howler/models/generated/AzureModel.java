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
public class AzureModel implements GeneratedModel {
  String resourceGroup;
  String resourceId;
  String subscriptionId;
  String tenantId;
  String upn;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("resource_group", resourceGroup, "String"),
        new Field("resource_id", resourceId, "String"),
        new Field("subscription_id", subscriptionId, "String"),
        new Field("tenant_id", tenantId, "String"),
        new Field("upn", upn, "String"));
  }
}