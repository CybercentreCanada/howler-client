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
public class HowlerModel implements GeneratedModel {
  String analytic;
  String assessment;
  String assignment;
  List<String> bundles;
  List<CommentModel> comment;
  Double confidence;
  List<String> data;
  String detection;
  Map<String, String> dossier;
  String escalation;
  String hash;
  List<String> hits;
  String id;
  Boolean isBundle;
  LabelsModel labels;
  List<LinkModel> links;
  List<LogModel> log;
  String mitigated;
  String monitored;
  OutlineModel outline;
  String rationale;
  List<String> related;
  Double reliability;
  String reported;
  String retained;
  Double score;
  String scrutiny;
  Double severity;
  String status;
  List<String> viewers;
  Double volume;
  VotesModel votes;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("analytic", analytic, "String"),
      new Field("assessment", assessment, "String"),
      new Field("assignment", assignment, "String"),
      new Field("bundles", bundles, "List<String>"),
      new Field("comment", comment, "List<Class>"),
      new Field("confidence", confidence, "Double"),
      new Field("data", data, "List<String>"),
      new Field("detection", detection, "String"),
      new Field("dossier", dossier, "Map<String, String>"),
      new Field("escalation", escalation, "String"),
      new Field("hash", hash, "String"),
      new Field("hits", hits, "List<String>"),
      new Field("id", id, "String"),
      new Field("is_bundle", isBundle, "Boolean"),
      new Field("labels", labels != null ? labels.getFields() : null, "Class"),
      new Field("links", links, "List<Class>"),
      new Field("log", log, "List<Class>"),
      new Field("mitigated", mitigated, "String"),
      new Field("monitored", monitored, "String"),
      new Field("outline", outline != null ? outline.getFields() : null, "Class"),
      new Field("rationale", rationale, "String"),
      new Field("related", related, "List<String>"),
      new Field("reliability", reliability, "Double"),
      new Field("reported", reported, "String"),
      new Field("retained", retained, "String"),
      new Field("score", score, "Double"),
      new Field("scrutiny", scrutiny, "String"),
      new Field("severity", severity, "Double"),
      new Field("status", status, "String"),
      new Field("viewers", viewers, "List<String>"),
      new Field("volume", volume, "Double"),
      new Field("votes", votes != null ? votes.getFields() : null, "Class")
    );
  }
}
