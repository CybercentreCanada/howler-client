package io.github.cybercentrecanada.howler.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

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
