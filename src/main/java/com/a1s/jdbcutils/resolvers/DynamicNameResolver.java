package com.a1s.jdbcutils.resolvers;

/**
 * Runtime resolve names. This resolver needs entity class and entity object.
 */
public interface DynamicNameResolver {
    String resolve(Class cls, Object o, String nameToResolve);
}
