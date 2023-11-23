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
public class ThreatModel implements GeneratedModel {
  FeedModel feed;
  String framework;
  ThreatGroupModel group;
  IndicatorModel indicator;
  SoftwareModel software;
  ThreatTacticModel tactic;
  ThreatTechniqueModel technique;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("feed", feed != null ? feed.getFields() : null, "Class"),
      new Field("framework", framework, "String"),
      new Field("group", group != null ? group.getFields() : null, "Class"),
      new Field("indicator", indicator != null ? indicator.getFields() : null, "Class"),
      new Field("software", software != null ? software.getFields() : null, "Class"),
      new Field("tactic", tactic != null ? tactic.getFields() : null, "Class"),
      new Field("technique", technique != null ? technique.getFields() : null, "Class")
    );
  }
}
