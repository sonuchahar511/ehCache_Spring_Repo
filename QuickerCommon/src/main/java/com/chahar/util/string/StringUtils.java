package com.chahar.util.string;

public class StringUtils {
    private StringUtils() {
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.length("XXXXXXXX_YYYYYYY_ZZZZZZZZZZZ"));
    }

    public static int length(final String text) {
        return text == null || "".equals(text) ? 0 : text.length();
    }
}
