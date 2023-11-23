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
public class HitModel implements GeneratedModel {
  AgentModel agent;
  AssemblylineModel assemblyline;
  AwsModel aws;
  AzureModel azure;
  CbsModel cbs;
  CloudModel cloud;
  ContainerModel container;
  DestinationModel destination;
  DnsModel dns;
  EcsModel ecs;
  EmailModel email;
  ErrorModel error;
  EventModel event;
  FaasModel faas;
  HitFileModel file;
  GcpModel gcp;
  GroupModel group;
  HostModel host;
  HowlerModel howler;
  HttpModel http;
  Map<String, String> labels;
  HitOrganizationModel organization;
  ProcessModel process;
  RegistryModel registry;
  RelatedModel related;
  ServerModel server;
  SourceModel source;
  SpellbookModel spellbook;
  List<String> tags;
  ThreatModel threat;
  String timestamp;
  TlsModel tls;
  UrlModel url;
  HitUserModel user;
  UserAgentModel userAgent;
  VulnerabilityModel vulnerability;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("agent", agent != null ? agent.getFields() : null, "Class"),
      new Field("assemblyline", assemblyline != null ? assemblyline.getFields() : null, "Class"),
      new Field("aws", aws != null ? aws.getFields() : null, "Class"),
      new Field("azure", azure != null ? azure.getFields() : null, "Class"),
      new Field("cbs", cbs != null ? cbs.getFields() : null, "Class"),
      new Field("cloud", cloud != null ? cloud.getFields() : null, "Class"),
      new Field("container", container != null ? container.getFields() : null, "Class"),
      new Field("destination", destination != null ? destination.getFields() : null, "Class"),
      new Field("dns", dns != null ? dns.getFields() : null, "Class"),
      new Field("ecs", ecs != null ? ecs.getFields() : null, "Class"),
      new Field("email", email != null ? email.getFields() : null, "Class"),
      new Field("error", error != null ? error.getFields() : null, "Class"),
      new Field("event", event != null ? event.getFields() : null, "Class"),
      new Field("faas", faas != null ? faas.getFields() : null, "Class"),
      new Field("file", file != null ? file.getFields() : null, "Class"),
      new Field("gcp", gcp != null ? gcp.getFields() : null, "Class"),
      new Field("group", group != null ? group.getFields() : null, "Class"),
      new Field("host", host != null ? host.getFields() : null, "Class"),
      new Field("howler", howler != null ? howler.getFields() : null, "Class"),
      new Field("http", http != null ? http.getFields() : null, "Class"),
      new Field("labels", labels, "Map<String, String>"),
      new Field("organization", organization != null ? organization.getFields() : null, "Class"),
      new Field("process", process != null ? process.getFields() : null, "Class"),
      new Field("registry", registry != null ? registry.getFields() : null, "Class"),
      new Field("related", related != null ? related.getFields() : null, "Class"),
      new Field("server", server != null ? server.getFields() : null, "Class"),
      new Field("source", source != null ? source.getFields() : null, "Class"),
      new Field("spellbook", spellbook != null ? spellbook.getFields() : null, "Class"),
      new Field("tags", tags, "List<String>"),
      new Field("threat", threat != null ? threat.getFields() : null, "Class"),
      new Field("timestamp", timestamp, "String"),
      new Field("tls", tls != null ? tls.getFields() : null, "Class"),
      new Field("url", url != null ? url.getFields() : null, "Class"),
      new Field("user", user != null ? user.getFields() : null, "Class"),
      new Field("user_agent", userAgent != null ? userAgent.getFields() : null, "Class"),
      new Field("vulnerability", vulnerability != null ? vulnerability.getFields() : null, "Class")
    );
  }
}
