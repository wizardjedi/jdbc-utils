package com.a1s.jdbcutils;

import com.a1s.jdbcutils.meta.MetaField;
import com.a1s.jdbcutils.meta.TableMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JdbcUtil<T> {
    private static final Logger log = LoggerFactory.getLogger(JdbcUtil.class);

    protected TableMetaData metadata;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /*@Autowired
    protected ConversionService cc;*/

    public List<T> getList() {
        return null;
    }

    public void delete(T o) {

    }

    public T save(T objectToSave) {
        initializeMetaData(objectToSave);

        generateInsertQuery();

        return null;
    }

    protected void generateInsertQuery() {

        final List<MetaField> allFields = new ArrayList<>();
        allFields.addAll(metadata.getIdFields());
        allFields.addAll(metadata.getFields());

        final List<String> allFieldNames = allFields.stream().map(MetaField::getFieldName).collect(Collectors.toList());

        final String insertQuery =
            String
                .format(
                    JdbcUtilConstants.QueryTemplates.INSERT_TEMPLATE,
                    metadata.resolveTableName(null),
                    StringUtils.collectionToCommaDelimitedString(allFieldNames),
                    CommonUtils.repeat("?", allFields.size(),",", "(%s)")
                );

        log.trace("Insert query:{}", insertQuery);

    }

    protected void initializeMetaData(T o) {
        if (metadata != null) {
            return;
        }

        metadata = MetaDataBuilder.build(o);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public JdbcUtil<T> setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        return this;
    }
}
