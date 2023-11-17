package cccs.hogwarts.howler.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Field {
    String key;
    Object value;
    String type;
}
