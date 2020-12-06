package com.lks.rowmapper;

import com.lks.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName EmployeeRowMapperTest
 * @Description TODO
 * @Author lks
 * @Date 2020/4/18 10:17
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeRowMapperTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    List<Employee> list;

    @Test
    public void baseRowMapperTest() {
        list = jdbcTemplate.query("select * from tbl_emp", new BaseRowMapper(Employee.class));
        System.out.println(list.size());
    }
}
