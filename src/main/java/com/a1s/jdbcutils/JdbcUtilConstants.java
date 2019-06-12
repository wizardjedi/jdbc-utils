package com.a1s.jdbcutils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class JdbcUtilConstants {
    public static class QueryTemplates {
        public static final String INSERT_TEMPLATE = "INSERT INTO %s (%s) VALUES %s;";

        public static final String UPDATE_TEMPLATE = "UPDATE %s SET %s WHERE %s=%s;";

        public static final String SELECT_TEMPLATE = "SELECT * FROM %s";

        public static final String DELETE_TEMPLATE = "DELETE FROM %s WHERE %s=%s;";
    }

    public static Map<Class, Class> typeMapping = new HashMap<Class, Class>();

    static {
        //typeMapping.put(String.class, java.sql.);
        typeMapping.put(LocalDate.class, java.sql.Timestamp.class);
        typeMapping.put(LocalDate.class, java.sql.Date.class);
        typeMapping.put(LocalTime.class, java.sql.Time.class);

    }
}
