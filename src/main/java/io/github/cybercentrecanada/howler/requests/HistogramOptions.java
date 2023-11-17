package io.github.cybercentrecanada.howler.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HistogramOptions {
    String query;
    @JsonProperty("mincount")
    Integer mincount;
    List<String> filters;
    Integer start;
    Integer end;
    Integer gap;
}
