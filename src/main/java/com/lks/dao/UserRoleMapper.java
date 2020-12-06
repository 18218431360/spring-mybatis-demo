package com.lks.dao;

import com.lks.bean.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer rmId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer rmId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}