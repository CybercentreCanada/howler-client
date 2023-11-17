package cccs.hogwarts.howler.models;

import cccs.hogwarts.howler.models.generated.HitModel;
import lombok.Data;

@Data
public class InvalidHitModel {
    HitModel input;
    String error;
}
