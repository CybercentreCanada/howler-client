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
public class ParentModel implements GeneratedModel {
  BccModel bcc;
  CcModel cc;
  String destination;
  FromModel from;
  String messageId;
  String originationTimestamp;
  String source;
  String subject;
  ToModel to;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("bcc", bcc != null ? bcc.getFields() : null, "Class"),
        new Field("cc", cc != null ? cc.getFields() : null, "Class"),
        new Field("destination", destination, "String"),
        new Field("from", from != null ? from.getFields() : null, "Class"),
        new Field("message_id", messageId, "String"),
        new Field("origination_timestamp", originationTimestamp, "String"),
        new Field("source", source, "String"),
        new Field("subject", subject, "String"),
        new Field("to", to != null ? to.getFields() : null, "Class"));
  }
}
