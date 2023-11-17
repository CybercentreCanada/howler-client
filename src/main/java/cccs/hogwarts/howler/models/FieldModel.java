package cccs.hogwarts.howler.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FieldModel {
    @JsonProperty("default")
    Boolean isDefault;

    Boolean indexed;

    Boolean list;

    Boolean stored;

    String type;
}
