package com.lks.dao;

import com.lks.bean.RoleMenu;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer rmId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Integer rmId);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}