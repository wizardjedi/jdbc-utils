package com.a1s.jdbcutils;

import org.springframework.util.StringUtils;

public class CommonUtils {
    public static String repeat(String r, int times, String delimeter) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= times; i++) {
            sb.append(r);

            if (i != times) {
                sb.append(delimeter);
            }
        }

        return sb.toString();
    }

    public static String repeat(String r, int times, String delimeter, String format) {
        return String.format(format, repeat(r, times, delimeter));
    }

    public static String camelCaseToUnderscore(String s) {
        final char[] charArr = s.toCharArray();

        int length = 1;

        int pos = 1;

        final char[] buffer = new char[s.length() * 2];

        if (Character.isUpperCase(charArr[0])) {
            buffer[0] = Character.toLowerCase(charArr[0]);
        } else {
            buffer[0] = charArr[0];
        }

        for (int i=1;i<charArr.length;i++) {
            if (Character.isUpperCase(charArr[i])) {
                buffer[pos] = '_';
                buffer[pos+1] = Character.toLowerCase(charArr[i]);

                pos +=2;
                length +=2;
            } else {
                buffer[pos] = charArr[i];
                pos++;
                length++;
            }
        }

        return String.copyValueOf(buffer, 0, length);
    }


}
