package com.lks.service;

import com.lks.bean.Employee;
import com.lks.dao.impl.EmployeeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description 员工
 * @Author lks
 * @Date 2020/4/18 13:03
 * @Version 1.0
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeDaoImpl employeeDao;

    public List<Employee> getAll(){
        List<Employee> employeeList = employeeDao.selectByMap(null);
        return employeeList;
    }


}
