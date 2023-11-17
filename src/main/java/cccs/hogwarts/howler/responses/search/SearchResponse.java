package cccs.hogwarts.howler.responses.search;

import cccs.hogwarts.howler.models.SearchModel;
import cccs.hogwarts.howler.responses.HowlerResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchResponse<T> extends HowlerResponse<SearchModel<T>> {

}