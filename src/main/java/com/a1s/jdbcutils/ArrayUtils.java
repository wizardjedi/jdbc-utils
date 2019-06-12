package com.a1s.jdbcutils;

import java.util.Arrays;

public class ArrayUtils {
    public static <T> T find(T[] array, Class requiredClass) {
        for (final T o: array) {
            if (requiredClass.isAssignableFrom(o.getClass())) {
                return o;
            }
        }

        return null;
    }
}
