package io.github.cybercentrecanada.howler.requests;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatsOptions {
    String query;
    List<String> filters;
}
