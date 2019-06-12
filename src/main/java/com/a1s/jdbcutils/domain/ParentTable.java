package com.a1s.jdbcutils.domain;

import java.time.LocalDateTime;

public class ParentTable {
    protected LocalDateTime createDate;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public ParentTable setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }
}
