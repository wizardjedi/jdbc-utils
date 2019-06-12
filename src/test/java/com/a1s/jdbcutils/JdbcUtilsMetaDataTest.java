package com.a1s.jdbcutils;

import com.a1s.jdbcutils.exceptions.NoIdFieldException;
import com.a1s.jdbcutils.exceptions.NoTableAnnotationException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class JdbcUtilsMetaDataTest {
    public static final String TABLE_NAME = "table_name";

    @Test(expected = NoTableAnnotationException.class)
    public void testNoTableAnnotation() {
        MetaDataBuilder.build(new NoTableAnnotationClass());
    }

    public static class NoTableAnnotationClass{

    }

    @Test(expected = NoIdFieldException.class)
    public void testNoIdFieldException() {
        MetaDataBuilder.build(new NoIdFieldClass());
    }

    @Table
    public static class NoIdFieldClass {

    }

    @Test
    public void testSettingTableName() {
        Assert.assertNull(MetaDataBuilder.build(new TableNameNotSpecifiedClass()).getStaticTableName());
        Assert.assertEquals(TABLE_NAME, MetaDataBuilder.build(new TableNameSpecifiedClass()).getStaticTableName());
    }

    @Table
    public static class TableNameNotSpecifiedClass {
        @Id
        protected Long id;
    }

    @Table(name = TABLE_NAME)
    public static class TableNameSpecifiedClass {
        @Id
        protected Long id;
    }

}
