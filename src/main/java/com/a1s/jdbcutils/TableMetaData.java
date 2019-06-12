package com.a1s.jdbcutils;

import java.util.List;

public class TableMetaData {
    protected List idFields;
    protected List fields;

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
