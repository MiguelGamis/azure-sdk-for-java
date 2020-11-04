// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for StringIndexTypeResponse.
 */
public enum StringIndexTypeResponse {
    /**
     * Enum value TextElements_v8.
     */
    TEXT_ELEMENTS_V8("TextElements_v8"),

    /**
     * Enum value UnicodeCodePoint.
     */
    UNICODE_CODE_POINT("UnicodeCodePoint"),

    /**
     * Enum value Utf16CodeUnit.
     */
    UTF16CODE_UNIT("Utf16CodeUnit");

    /**
     * The actual serialized value for a StringIndexTypeResponse instance.
     */
    private final String value;

    StringIndexTypeResponse(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a StringIndexTypeResponse instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed StringIndexTypeResponse object, or null if unable to parse.
     */
    @JsonCreator
    public static StringIndexTypeResponse fromString(String value) {
        StringIndexTypeResponse[] items = StringIndexTypeResponse.values();
        for (StringIndexTypeResponse item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
