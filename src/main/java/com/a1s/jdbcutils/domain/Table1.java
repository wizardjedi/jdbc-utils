package com.a1s.jdbcutils.domain;

import com.a1s.jdbcutils.Id;
import com.a1s.jdbcutils.Table;
import com.a1s.jdbcutils.Transient;

@Table
public class Table1 extends ParentTable {
    @Id
    protected Long id;
    protected String text;

    @Transient
    protected String transientField;

    public Long getId() {
        return id;
    }

    public Table1 setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Table1 setText(String text) {
        this.text = text;
        return this;
    }

    public String getTransientField() {
        return transientField;
    }

    public Table1 setTransientField(String transientField) {
        this.transientField = transientField;
        return this;
    }
}
