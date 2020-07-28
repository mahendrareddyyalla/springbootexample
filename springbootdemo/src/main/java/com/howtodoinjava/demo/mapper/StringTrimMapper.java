package com.howtodoinjava.demo.mapper;

import org.springframework.stereotype.Component;

/**
 * Mapper which trims Strings.
 */
@Component
public class StringTrimMapper {

    /**
     * Trims the {@link String} value that was provided.
     *
     * @param value The Value to be mapped.
     * @return The Value that is trimmed if it is not null.
     */
    @SuppressWarnings({"unused", "WeakerAccess"})
    public String trim(String value) {
        return value == null ? null : value.trim();
    }
}