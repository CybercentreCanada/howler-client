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
public class EmailModel implements GeneratedModel {
  List<AttachmentModel> attachments;
  BccModel bcc;
  CcModel cc;
  String contentType;
  String deliveryTimestamp;
  String direction;
  FromModel from;
  String localId;
  String messageId;
  String originationTimestamp;
  ParentModel parent;
  ReplyToModel replyTo;
  SenderModel sender;
  String subject;
  ToModel to;
  String xMailer;

  @Override
  @JsonIgnore
  public List<Field> getFields() {
    return List.of(
      new Field("attachments", attachments, "List<Class>"),
      new Field("bcc", bcc != null ? bcc.getFields() : null, "Class"),
      new Field("cc", cc != null ? cc.getFields() : null, "Class"),
      new Field("content_type", contentType, "String"),
      new Field("delivery_timestamp", deliveryTimestamp, "String"),
      new Field("direction", direction, "String"),
      new Field("from", from != null ? from.getFields() : null, "Class"),
      new Field("local_id", localId, "String"),
      new Field("message_id", messageId, "String"),
      new Field("origination_timestamp", originationTimestamp, "String"),
      new Field("parent", parent != null ? parent.getFields() : null, "Class"),
      new Field("reply_to", replyTo != null ? replyTo.getFields() : null, "Class"),
      new Field("sender", sender != null ? sender.getFields() : null, "Class"),
      new Field("subject", subject, "String"),
      new Field("to", to != null ? to.getFields() : null, "Class"),
      new Field("x_mailer", xMailer, "String")
    );
  }
}
