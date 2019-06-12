package com.a1s.jdbcutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class TestConfiguration {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
