package com.a1s.jdbcutils.resolvers;

public interface NameResolver {
    String resolve(Class cls, String nameToResolve);
}
