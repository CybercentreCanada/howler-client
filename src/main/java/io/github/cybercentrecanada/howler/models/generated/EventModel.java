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
public class EventModel implements GeneratedModel {
  String action;
  List<String> category;
  String code;
  String created;
  String dataset;
  Integer duration;
  String end;
  String hash;
  String id;
  String ingested;
  String kind;
  String module;
  String original;
  String outcome;
  String provider;
  String reason;
  String reference;
  Double riskScore;
  Double riskScoreNorm;
  Integer sequence;
  Integer severity;
  String start;
  String timezone;
  List<String> type;
  String url;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
        new Field("action", action, "String"),
        new Field("category", category, "List<String>"),
        new Field("code", code, "String"),
        new Field("created", created, "String"),
        new Field("dataset", dataset, "String"),
        new Field("duration", duration, "Integer"),
        new Field("end", end, "String"),
        new Field("hash", hash, "String"),
        new Field("id", id, "String"),
        new Field("ingested", ingested, "String"),
        new Field("kind", kind, "String"),
        new Field("module", module, "String"),
        new Field("original", original, "String"),
        new Field("outcome", outcome, "String"),
        new Field("provider", provider, "String"),
        new Field("reason", reason, "String"),
        new Field("reference", reference, "String"),
        new Field("risk_score", riskScore, "Double"),
        new Field("risk_score_norm", riskScoreNorm, "Double"),
        new Field("sequence", sequence, "Integer"),
        new Field("severity", severity, "Integer"),
        new Field("start", start, "String"),
        new Field("timezone", timezone, "String"),
        new Field("type", type, "List<String>"),
        new Field("url", url, "String"));
  }
}
