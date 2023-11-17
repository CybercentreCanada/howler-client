package io.github.cybercentrecanada.howler.models;

import io.github.cybercentrecanada.howler.models.generated.HitModel;
import lombok.Data;

@Data
public class InvalidHitModel {
    HitModel input;
    String error;
}
