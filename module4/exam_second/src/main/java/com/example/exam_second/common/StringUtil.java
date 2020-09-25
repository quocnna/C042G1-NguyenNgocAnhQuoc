package com.example.exam_second.common;

import java.util.Optional;
import java.util.regex.Pattern;

public class StringUtil {
    public static final String query = "test";
    private static final Pattern patternIsNumber = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static int parseIntegerOrDefault(String val){
        return Optional.ofNullable(val).filter(i->!i.isEmpty() && patternIsNumber.matcher(val).matches()).map(Integer::valueOf).orElse(-1);
    }

    public static double parseDoubleOrDefault(String val){
        return Optional.ofNullable(val).filter(i->!i.isEmpty() && patternIsNumber.matcher(val).matches()).map(Double::valueOf).orElse(-1.0);
    }
}
