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
public class AssemblylineModel implements GeneratedModel {
  List<AntivirusModel> antivirus;
  List<AttributionModel> attribution;
  List<BehaviourModel> behaviour;
  List<DomainModel> domain;
  List<HeuristicModel> heuristic;
  MitreModel mitre;
  List<UriModel> uri;
  List<YaraModel> yara;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("antivirus", antivirus, "List<Class>"),
        new Field("attribution", attribution, "List<Class>"),
        new Field("behaviour", behaviour, "List<Class>"),
        new Field("domain", domain, "List<Class>"),
        new Field("heuristic", heuristic, "List<Class>"),
        new Field("mitre", mitre != null ? mitre.getFields() : null, "Class"),
        new Field("uri", uri, "List<Class>"),
        new Field("yara", yara, "List<Class>"));
  }
}
