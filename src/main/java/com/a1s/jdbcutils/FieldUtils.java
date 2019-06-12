package com.a1s.jdbcutils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldUtils {
    public static boolean isAnnotatedField(Annotation[] annotations, Class a) {
        if (annotations == null || annotations.length == 0) {
            return false;
        } else {
            final Annotation annotation = ArrayUtils.find(annotations, a);

            if (annotation == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean isTransient(Annotation[] annotations) {
        return isAnnotatedField(annotations, Transient.class);
    }

    public static boolean isId(Annotation[] annotations) {
        return isAnnotatedField(annotations, Id.class);
    }

    public static boolean isTable(Annotation[] annotations) {
        return isAnnotatedField(annotations, Table.class);
    }
}
