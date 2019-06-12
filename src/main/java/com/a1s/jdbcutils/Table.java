package com.a1s.jdbcutils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
public @interface Table {
    String value() default "";

    String name() default "";

    Class tableNameResolver() default SimpleTableNameResolver.class;

    Class fieldNameResolver() default SimpleFieldNameResolver.class;
}
