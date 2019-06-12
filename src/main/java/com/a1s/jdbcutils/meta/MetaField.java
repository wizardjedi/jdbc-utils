package com.a1s.jdbcutils.meta;

import com.a1s.jdbcutils.resolvers.NameResolver;

import java.beans.PropertyDescriptor;

public class MetaField {
    protected String fieldName;
    protected String propertyName;
    protected NameResolver fieldNameResolver;
    protected NameResolver propertyNameResolver;
    protected PropertyDescriptor propertyDescriptor;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MetaField{");
        sb.append("fieldName='").append(fieldName).append('\'');
        sb.append(", propertyName='").append(propertyName).append('\'');
        sb.append(", fieldNameResolver=").append(fieldNameResolver);
        sb.append(", propertyNameResolver=").append(propertyNameResolver);
        sb.append(", propertyDescriptor=").append(propertyDescriptor);
        sb.append('}');
        return sb.toString();
    }

    public PropertyDescriptor getPropertyDescriptor() {
        return propertyDescriptor;
    }

    public MetaField setPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
        this.propertyDescriptor = propertyDescriptor;
        return this;
    }

    public NameResolver getFieldNameResolver() {
        return fieldNameResolver;
    }

    public MetaField setFieldNameResolver(NameResolver fieldNameResolver) {
        this.fieldNameResolver = fieldNameResolver;
        return this;
    }

    public NameResolver getPropertyNameResolver() {
        return propertyNameResolver;
    }

    public MetaField setPropertyNameResolver(NameResolver propertyNameResolver) {
        this.propertyNameResolver = propertyNameResolver;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public MetaField setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public MetaField setPropertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }
}
