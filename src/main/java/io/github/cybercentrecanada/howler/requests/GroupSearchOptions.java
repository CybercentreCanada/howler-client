package io.github.cybercentrecanada.howler.requests;

import lombok.*;

import java.util.List;

@Data
@Builder
public class GroupSearchOptions {
    String groupSort;
    Integer limit;
    String query;
    List<String> filters;
    Integer offset;
    Integer rows;
    String sort;

    // We special case fields to make things easier
    @Setter(AccessLevel.NONE)
    private String fl;

    public void setFields(List<String> fields) {
        if (fields == null) {
            this.fl = null;
        } else {
            this.fl = String.join(",", fields);
        }
    }

    @SuppressWarnings("unused")
    public static class GroupSearchOptionsBuilder {
        public GroupSearchOptionsBuilder fields(List<String> fields) {
            if (fields == null) {
                this.fl = null;
            } else {
                this.fl = String.join(",", fields);
            }

            return this;
        }

        @SuppressWarnings("unused")
        private GroupSearchOptionsBuilder fl(String fl) {
            return this;
        }
    }
}
