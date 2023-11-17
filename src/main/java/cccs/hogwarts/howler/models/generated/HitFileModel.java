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
public class HitFileModel implements GeneratedModel {
  String accessed;
  List<String> attributes;
  CodeSignatureModel codeSignature;
  String created;
  String ctime;
  String device;
  String directory;
  String driveLetter;
  ElfModel elf;
  String extension;
  String forkName;
  String gid;
  String group;
  FileHashModel hash;
  String inode;
  String mimeType;
  String mode;
  String mtime;
  String name;
  String owner;
  String path;
  PeModel pe;
  Integer size;
  String targetPath;
  String type;
  String uid;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("accessed", accessed, "String"),
      new Field("attributes", attributes, "List<String>"),
      new Field("code_signature", codeSignature != null ? codeSignature.getFields() : null, "Class"),
      new Field("created", created, "String"),
      new Field("ctime", ctime, "String"),
      new Field("device", device, "String"),
      new Field("directory", directory, "String"),
      new Field("drive_letter", driveLetter, "String"),
      new Field("elf", elf != null ? elf.getFields() : null, "Class"),
      new Field("extension", extension, "String"),
      new Field("fork_name", forkName, "String"),
      new Field("gid", gid, "String"),
      new Field("group", group, "String"),
      new Field("hash", hash != null ? hash.getFields() : null, "Class"),
      new Field("inode", inode, "String"),
      new Field("mime_type", mimeType, "String"),
      new Field("mode", mode, "String"),
      new Field("mtime", mtime, "String"),
      new Field("name", name, "String"),
      new Field("owner", owner, "String"),
      new Field("path", path, "String"),
      new Field("pe", pe != null ? pe.getFields() : null, "Class"),
      new Field("size", size, "Integer"),
      new Field("target_path", targetPath, "String"),
      new Field("type", type, "String"),
      new Field("uid", uid, "String")
    );
  }
}
