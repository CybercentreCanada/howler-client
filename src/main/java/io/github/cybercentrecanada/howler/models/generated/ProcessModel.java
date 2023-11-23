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
public class ProcessModel implements GeneratedModel {
  List<String> args;
  Integer argsCount;
  String commandLine;
  String end;
  String entityId;
  Map<String, String> envVars;
  String executable;
  Integer exitCode;
  Boolean interactive;
  String name;
  List<ProcessParentModel> parent;
  Integer pid;
  Boolean sameAsProcess;
  String start;
  String title;
  Integer uptime;
  UserModel user;
  String workingDirectory;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("args", args, "List<String>"),
      new Field("args_count", argsCount, "Integer"),
      new Field("command_line", commandLine, "String"),
      new Field("end", end, "String"),
      new Field("entity_id", entityId, "String"),
      new Field("env_vars", envVars, "Map<String, String>"),
      new Field("executable", executable, "String"),
      new Field("exit_code", exitCode, "Integer"),
      new Field("interactive", interactive, "Boolean"),
      new Field("name", name, "String"),
      new Field("parent", parent, "List<Class>"),
      new Field("pid", pid, "Integer"),
      new Field("same_as_process", sameAsProcess, "Boolean"),
      new Field("start", start, "String"),
      new Field("title", title, "String"),
      new Field("uptime", uptime, "Integer"),
      new Field("user", user != null ? user.getFields() : null, "Class"),
      new Field("working_directory", workingDirectory, "String")
    );
  }
}
