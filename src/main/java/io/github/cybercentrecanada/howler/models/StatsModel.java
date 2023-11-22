package io.github.cybercentrecanada.howler.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StatsModel {
    Integer count;
    Integer min;
    Integer max;
    Integer avg;
    Integer sum;
}
