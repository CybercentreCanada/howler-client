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
public class DnsModel implements GeneratedModel {
  List<AnswerModel> answers;
  List<String> headerFlags;
  String id;
  String opCode;
  QuestionModel question;
  List<String> resolvedIp;
  String responseCode;
  String type;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("answers", answers, "List<Class>"),
      new Field("header_flags", headerFlags, "List<String>"),
      new Field("id", id, "String"),
      new Field("op_code", opCode, "String"),
      new Field("question", question != null ? question.getFields() : null, "Class"),
      new Field("resolved_ip", resolvedIp, "List<String>"),
      new Field("response_code", responseCode, "String"),
      new Field("type", type, "String")
    );
  }
}
