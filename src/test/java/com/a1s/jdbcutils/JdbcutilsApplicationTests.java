package com.a1s.jdbcutils;

import com.a1s.jdbcutils.domain.Table1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import({TestConfiguration.class})
public class JdbcutilsApplicationTests {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected JdbcUtil<Table1> table1JdbcUtil;

    @Test
    public void contextLoads() {
        System.out.println(jdbcTemplate.queryForObject("select 1+2;", Long.class));

        table1JdbcUtil.save(new Table1());
    }

}
