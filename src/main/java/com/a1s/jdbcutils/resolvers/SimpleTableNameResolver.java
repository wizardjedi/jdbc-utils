package com.a1s.jdbcutils.resolvers;

import com.a1s.jdbcutils.CommonUtils;

public class SimpleTableNameResolver implements StaticNameResolver {
    @Override
    public String resolve(Class cls, String nameToResolve) {
        return CommonUtils.camelCaseToUnderscore(nameToResolve);
    }
}
