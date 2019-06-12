package com.a1s.jdbcutils.resolvers;

import com.a1s.jdbcutils.CommonUtils;

public class SimpleFieldNameResolver implements StaticNameResolver {
    @Override
    public String resolve(Class cls, String propertyNameToResolve) {
        return CommonUtils.camelCaseToUnderscore(propertyNameToResolve);
    }
}
