package cccs.hogwarts.howler.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StatsOptions {
    String query;
    List<String> filters;
}
