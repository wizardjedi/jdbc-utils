package com.a1s.jdbcutils;

import com.a1s.jdbcutils.exceptions.NoIdFieldException;
import com.a1s.jdbcutils.exceptions.NoTableAnnotationException;
import com.a1s.jdbcutils.meta.MetaField;
import com.a1s.jdbcutils.meta.TableMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MetaDataBuilder {
    private static final Logger log = LoggerFactory.getLogger(MetaDataBuilder.class);

    public static TableMetaData build(Object o) {
        final TableMetaData metadata = new TableMetaData();

        final Annotation[] classAnnotations = o.getClass().getAnnotations();

        if (!FieldUtils.isTable(classAnnotations)) {
            throw new NoTableAnnotationException("Entity class must be annotated with @Table");
        }

        final Table tableAnnotation = o.getClass().getAnnotation(Table.class);

        if (tableAnnotation != null && StringUtils.hasText(tableAnnotation.name()) ) {
            metadata.setStaticTableName(tableAnnotation.name());
        }

        metadata.setEntityClass(o.getClass());

        ReflectionUtils
            .doWithFields(
                o.getClass(),
                (Field field) -> processField(metadata, field)
            );

        if (metadata.getIdFields() == null || metadata.getIdFields().isEmpty()) {
            throw new NoIdFieldException();
        }

        log.trace("Metadata after initialization:{}", metadata);

        return metadata;
    }

    public static void processField(TableMetaData metadata, Field field) {
        final Annotation[] fieldAnnotations = field.getAnnotations();

        if (FieldUtils.isTransient(fieldAnnotations)) {
            // nothing to do
            log.trace("Found transient field:{} omit it", field);

            return;
        } else {
            // Find id annotation
            if (FieldUtils.isId(fieldAnnotations)) {
                log.trace("Found id:{}", field);

                metadata.getIdFields().add(buildMetaField(metadata.getEntityClass(), field));
            } else {
                log.trace("Found regular field:{}", field);

                metadata.getFields().add(buildMetaField(metadata.getEntityClass(), field));
            }
        }
    }

    public static MetaField buildMetaField(Class cls, Field field) {
        final PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(cls, field.getName());

        final MetaField mf = new MetaField();

        mf.setPropertyName(field.getName());
        mf.setPropertyDescriptor(propertyDescriptor);

        return mf;
    }
}
