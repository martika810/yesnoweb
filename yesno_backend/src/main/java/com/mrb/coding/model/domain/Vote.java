package com.mrb.coding.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Maps;

import java.util.Map;

public enum Vote {
    YES("yes"),
    NEUTRAL("neutral"),
    NO("no");

    private static final Map<String, Vote> nameIndex =
            Maps.newHashMapWithExpectedSize(Vote.values().length);

    static {
        for (Vote vote : Vote.values()) {
            nameIndex.put(vote.getValue(), vote);
        }
    }

    @JsonCreator
    public static Vote lookupByName(String name) {
        return nameIndex.get(name);
    }


    private final String value;

    Vote(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
