package io.github.cybercentrecanada.howler.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SearchModel<T> {
    Integer total;
    Integer offset;
    Integer rows;
    String nextDeepPagingId;
    List<T> items;
}
