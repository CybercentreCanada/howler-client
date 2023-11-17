package io.github.cybercentrecanada.howler.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@Builder
public class SearchOptions {
    String query;
    String deepPagingId;
    List<String> filters;
    Integer offset;
    Integer rows;
    String sort;

    // We special case fields to make things easier
    @Setter(AccessLevel.NONE)
    private String fl;

    Integer timeout;
    Boolean useArchive;

    public void setFields(List<String> fields) {
        if (fields == null) {
            this.fl = null;
        } else {
            this.fl = String.join(",", fields);
        }
    }

    @SuppressWarnings("unused")
    public static class SearchOptionsBuilder {
        public SearchOptionsBuilder fields(List<String> fields) {
            if (fields == null) {
                this.fl = null;
            } else {
                this.fl = String.join(",", fields);
            }

            return this;
        }

        @SuppressWarnings("unused")
        private SearchOptionsBuilder fl(String fl) {
            return this;
        }
    }
}
