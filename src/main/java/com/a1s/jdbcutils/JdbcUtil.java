package com.a1s.jdbcutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class JdbcUtil<T> {

    protected

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /*@Autowired
    protected ConversionService cc;*/

    public List<T> getList() {
        return null;
    }

    public void delete(T o) {

    }

    public T save(T o) {
        ReflectionUtils
            .doWithFields(
                o.getClass(),
                (ReflectionUtils.FieldCallback) field -> {
                    field.

                    System.out.println("Field:" + field);
                }
            );


        return null;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public JdbcUtil<T> setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        return this;
    }
}
