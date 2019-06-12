package com.a1s.jdbcutils;

import com.a1s.jdbcutils.resolvers.NameResolver;
import com.a1s.jdbcutils.resolvers.SimpleFieldNameResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String name();

    // Add mapper to/from object?

    Class fieldNameResolver() default SimpleFieldNameResolver.class;
}
