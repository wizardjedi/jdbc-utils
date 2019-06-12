package com.a1s.jdbcutils.meta;

import com.a1s.jdbcutils.resolvers.DynamicNameResolver;
import com.a1s.jdbcutils.resolvers.NameResolver;
import com.a1s.jdbcutils.resolvers.SimpleTableNameResolver;
import com.a1s.jdbcutils.resolvers.StaticNameResolver;

import java.util.ArrayList;
import java.util.List;

public class TableMetaData {
    protected List idFields = new ArrayList();
    protected List fields = new ArrayList();

    protected String staticTableName;

    protected Class entityClass;
    protected NameResolver tableNameResolver = new SimpleTableNameResolver();

    public String resolveTableName(Object o) {
        if (tableNameResolver instanceof StaticNameResolver) {
            if (staticTableName == null) {
                staticTableName = tableNameResolver.resolve(entityClass, entityClass.getSimpleName());
            }

            return staticTableName;
        } else if (tableNameResolver instanceof DynamicNameResolver) {
            return ((DynamicNameResolver) tableNameResolver).resolve(entityClass, o, entityClass.getSimpleName());
        } else {
            throw new IllegalStateException("Unrecognized interface for name resolver");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TableMetaData{");
        sb.append("idFields=").append(idFields);
        sb.append(", fields=").append(fields);
        sb.append(", staticTableName='").append(staticTableName).append('\'');
        sb.append(", entityClass=").append(entityClass);
        sb.append(", tableNameResolver=").append(tableNameResolver);
        sb.append('}');
        return sb.toString();
    }

    public String getStaticTableName() {
        return staticTableName;
    }

    public TableMetaData setStaticTableName(String staticTableName) {
        this.staticTableName = staticTableName;
        return this;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public TableMetaData setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
        return this;
    }

    public NameResolver getTableNameResolver() {
        return tableNameResolver;
    }

    public TableMetaData setTableNameResolver(NameResolver tableNameResolver) {
        this.tableNameResolver = tableNameResolver;
        return this;
    }

    public List getIdFields() {
        return idFields;
    }

    public TableMetaData setIdFields(List idFields) {
        this.idFields = idFields;
        return this;
    }

    public List getFields() {
        return fields;
    }

    public TableMetaData setFields(List fields) {
        this.fields = fields;
        return this;
    }
}
