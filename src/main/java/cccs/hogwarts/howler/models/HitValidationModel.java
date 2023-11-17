package cccs.hogwarts.howler.models;

import cccs.hogwarts.howler.models.generated.HitModel;
import lombok.Data;

import java.util.List;

@Data
public class HitValidationModel {
    List<HitModel> valid;
    List<InvalidHitModel> invalid;
}
