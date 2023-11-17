package io.github.cybercentrecanada.howler.responses.search;

import io.github.cybercentrecanada.howler.models.SearchModel;
import io.github.cybercentrecanada.howler.responses.HowlerResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchResponse<T> extends HowlerResponse<SearchModel<T>> {

}
