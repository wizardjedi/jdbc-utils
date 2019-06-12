package com.a1s.jdbcutils.naming;

import com.a1s.jdbcutils.resolvers.SimpleFieldNameResolver;
import com.a1s.jdbcutils.resolvers.SimpleTableNameResolver;
import com.a1s.jdbcutils.resolvers.NameResolver;

public class DefaultNamingStrategy implements NamingStrategy {
    @Override
    public NameResolver getTableNameResolver() {
        return new SimpleTableNameResolver();
    }

    @Override
    public NameResolver getFieldNameResolver() {
        return new SimpleFieldNameResolver();
    }

    @Override
    public NameResolver getPropertyNameResolver() {
        return null;
    }
}
