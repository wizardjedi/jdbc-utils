package com.a1s.jdbcutils.naming;

import com.a1s.jdbcutils.resolvers.NameResolver;

public interface NamingStrategy {
    NameResolver getTableNameResolver();
    NameResolver getFieldNameResolver();
    NameResolver getPropertyNameResolver();
}
