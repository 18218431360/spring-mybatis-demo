package com.lks.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lks.bean.Employee;
import com.lks.bean.Msg;
import com.lks.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Source;
import java.util.List;

/**
 * @ClassName EmployeeController
 * @Description 员工
 * @Author lks
 * @Date 2020/4/18 13:03
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
    * 获取员工数据
    * @Param:
    * @return:
    */
    @ResponseBody
    @RequestMapping("/emps")
    public Msg getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        List<Employee> employeeList = employeeService.getAll();
        PageInfo pageInfo = new PageInfo(employeeList, 10);
        return new Msg().success().add("pageInfo",pageInfo);
    }

}
