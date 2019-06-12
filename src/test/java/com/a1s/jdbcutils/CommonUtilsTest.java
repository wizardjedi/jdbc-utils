package com.a1s.jdbcutils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommonUtilsTest {

    @Test
    public void camelCaseToUnderscore() {
        Assert.assertEquals("underscore_table_name1", CommonUtils.camelCaseToUnderscore("UnderscoreTableName1"));
        Assert.assertEquals("underscore_table_name1", CommonUtils.camelCaseToUnderscore("underscoreTableName1"));
        Assert.assertEquals("underscore_table_name_1", CommonUtils.camelCaseToUnderscore("underscoreTableName_1"));
    }
}
