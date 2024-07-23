package org.example.utils;


import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor
public class StringUtils {

    public static String toUTF8(String string) {
        return new String(string.getBytes(), StandardCharsets.UTF_8);
    }
}
