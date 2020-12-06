package com.lks.bean;

import com.lks.dao.impl.EmployeeDaoImpl;
import com.lks.daosupport.BaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName EmployeeDaoTest
 * @Description 员工测试
 * @Author lks
 * @Date 2020/4/17 11:04
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeDaoTest {

    @Autowired
    EmployeeDaoImpl employeeDao;

    /**
    * 查询
    * @Param:
    * @return:
    */
    @Test
    public void selectOne(){
        Employee employee = (Employee) employeeDao.selectByPrimaryKey(1);
        System.out.println(employee);
    }

    @Test
    public void selectAll(){
        List<Employee> employees = employeeDao.selectAll();
        System.out.println(employees.size());
    }


    @Test
    public void getAll(){
        List<Employee> employees = employeeDao.selectByMap(null);
        System.out.println(employees.size());
    }



}
