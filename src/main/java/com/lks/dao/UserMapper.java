package com.lks.dao;

import com.lks.bean.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userIs);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userIs);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Boolean batchInsert(List<User> userList);
}