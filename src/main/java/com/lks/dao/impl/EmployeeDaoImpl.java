package com.lks.dao.impl;

import com.lks.bean.Employee;
import com.lks.dao.EmployeeDao;
import com.lks.daosupport.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName EmployeeDaoImpl
 * @Description 员工接口
 * @Author lks
 * @Date 2020/4/17 10:08
 * @Version 1.0
 */
@Repository
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    @Override
    public int deleteByPrimaryKey(Integer empId) {
        return this.delete("com.lks.dao.EmployeeDao.deleteByPrimaryKey", empId);
    }

    @Override
    public int insert(Employee employee) {
        return this.insert("com.lks.dao.EmployeeDao.insert", employee);
    }

    @Override
    public int insertSelective(Employee employee) {
        return 0;
    }

    @Override
    public Employee selectByPrimaryKey(Integer empId) {
        return (Employee) this.selectOne("com.lks.dao.EmployeeDao.selectByPrimaryKey", empId);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee employee) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Employee employee) {
        return this.update("com.lks.dao.EmployeeDao.updateByPrimaryKey", employee);
    }

    @Override
    public List<Employee> selectAll() {
        return this.getSqlSession().selectList("com.lks.dao.EmployeeDao.selectAll", null);
    }

    @Override
    public List<Employee> selectByMap(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.lks.dao.EmployeeDao.selectByMap", map);
    }
}
