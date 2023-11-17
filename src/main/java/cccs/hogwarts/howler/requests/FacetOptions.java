package cccs.hogwarts.howler.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FacetOptions {
    String query;
    @JsonProperty("mincount")
    Integer mincount;
    List<String> filters;
}
