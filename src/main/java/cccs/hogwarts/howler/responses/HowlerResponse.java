package cccs.hogwarts.howler.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class HowlerResponse<T> {
    String apiErrorMessage;

    T apiResponse;

    String apiServerVersion;

    int apiStatusCode;
}
