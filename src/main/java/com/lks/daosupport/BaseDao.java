package com.lks.daosupport;

import com.lks.bean.Employee;
import org.apache.ibatis.session.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseDao
 * @Description 继承SqlSessionDaoSupport，获取一个SqlSessionTemplate
 * @Author lks
 * @Date 2020/4/16 22:01
 * @Version 1.0
 */
public class BaseDao extends SqlSessionDaoSupport {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 查询单个对象
     *
     * @Param:
     * @return:
     */
    public Object selectOne(String statement) {
        return this.getSqlSession().selectOne(statement);
    }

    public Object selectOne(String statement, Object parameter) {
        return this.getSqlSession().selectOne(statement, parameter);
    }

    /**
     * 查询，返回一个List集合
     *
     * @Param:
     * @return:
     */
    public List<Object> selectList(String statement) {
        return this.getSqlSession().selectList(statement);
    }

    public List<Object> selectList(String statement, Object parameter) {
        return this.getSqlSession().selectList(statement, parameter);
    }

    public List<Object> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return this.getSqlSession().selectList(statement, parameter, rowBounds);
    }

    /**
     * 查询，返回一个map集合
     *
     * @Param:
     * @return:
     */
    public Map<Object, Object> selectMap(String statement, String keymap) {
        return this.getSqlSession().selectMap(statement, keymap);
    }

    public Map<Object, Object> selectMap(String statement, Object parameter, String keymap) {
        return this.getSqlSession().selectMap(statement, parameter, keymap);
    }

    /**
     * 查询，返回一个map集合
     * RowBounds 限制返回数据条数
     *
     * @Param:
     * @return:
     */
    public Map<Object, Object> selectMap(String statement, Object parameter, String keymap, RowBounds rowBounds) {
        return this.getSqlSession().selectMap(statement, parameter, keymap, rowBounds);
    }

    /**
     * 新增
     *
     * @Param:
     * @return:
     */
    public int insert(String statement, Object Object) {
        return this.getSqlSession().insert(statement, Object);
    }

    /**
     * 更新
     *
     * @Param:
     * @return:
     */
    public int update(String statement) {
        return this.getSqlSession().update(statement);
    }

    public int update(String statement, Object Object) {
        return this.getSqlSession().update(statement, Object);
    }

    /**
     * 删除
     *
     * @Param:
     * @return:
     */
    public int delete(String statement) {
        return this.getSqlSession().delete(statement);
    }

    public int delete(String statement, Object Object) {
        return this.getSqlSession().delete(statement, Object);
    }

    /**
     * 获取connection连接，以便执行较为复杂的用法
     *
     * @Param:
     * @return:
     */
    public Connection getConnection() {
        return this.getConnection();
    }
}
