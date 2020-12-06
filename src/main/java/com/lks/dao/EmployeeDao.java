package com.lks.dao;

import com.lks.bean.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeDao {

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee employee);

    int insertSelective(Employee employee);

    Employee selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Employee employee);

    int updateByPrimaryKey(Employee employee);

    List<Employee> selectAll();

    List<Employee> selectByMap(HashMap<String, Object> map);

}