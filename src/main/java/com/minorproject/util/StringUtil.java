package com.minorproject.util;

import java.util.stream.Stream;

public class StringUtil {
    public static int countWords(String text) {
        String[] words = text.split(" ");
        return (int) Stream.of(words).filter(s -> !s.isEmpty()).count();
    }
}
