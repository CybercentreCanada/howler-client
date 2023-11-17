package io.github.cybercentrecanada.howler.models;

import lombok.Data;

import java.util.List;

@Data
public class GroupedModel<T> {
    String value;
    Integer total;
    List<T> items;
}
