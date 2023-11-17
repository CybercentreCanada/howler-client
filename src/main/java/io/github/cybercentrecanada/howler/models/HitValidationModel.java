package io.github.cybercentrecanada.howler.models;

import io.github.cybercentrecanada.howler.models.generated.HitModel;
import lombok.Data;

import java.util.List;

@Data
public class HitValidationModel {
    List<HitModel> valid;
    List<InvalidHitModel> invalid;
}
