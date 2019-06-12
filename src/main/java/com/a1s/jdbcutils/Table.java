package com.a1s.jdbcutils;

import com.a1s.jdbcutils.resolvers.SimpleFieldNameResolver;
import com.a1s.jdbcutils.resolvers.SimpleTableNameResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value() default "";

    String name() default "";

    Class tableNameResolver() default SimpleTableNameResolver.class;

    Class fieldNameResolver() default SimpleFieldNameResolver.class;
}
