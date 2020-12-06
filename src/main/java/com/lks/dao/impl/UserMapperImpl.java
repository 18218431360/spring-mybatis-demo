package com.lks.dao.impl;

import com.lks.bean.User;
import com.lks.dao.UserMapper;
import com.lks.daosupport.BaseDao;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapperImpl
 * @Description TODO
 * @Author lks
 * @Date 2020/4/19 18:39
 * @Version 1.0
 */
@Repository
public class UserMapperImpl extends BaseDao implements UserMapper {
    @Override
    public int deleteByPrimaryKey(Integer userIs) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userIs) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    /**
     * 批量插入
     *
     * @Param:
     * @return:
     */
    @Override
    public Boolean batchInsert(List<User> userList) {
        int result = 1;
        SqlSession sqlSession = null;

        try {
            sqlSession = this.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            int batchCount = 50000; // 每次插入1000条
            int lastIndex = batchCount; // 每批数据最后一条数据的下标
            for (int index = 0; index < userList.size(); ) {
                if (lastIndex >= userList.size()) { // 如果插入数据的最后一条下标大于总的数量值，执行完就结束
                    lastIndex = userList.size();
                    result = result * sqlSession.insert("com.lks.dao.UserMapper.batchInsert", userList.subList(index, lastIndex));
                    sqlSession.commit();
                    System.out.println("起始:" + index + "  " + "结束:" + lastIndex);
                    break;
                } else { // 总数据量大于batchCount
                    result = result * sqlSession.insert("com.lks.dao.UserMapper.batchInsert", userList.subList(index, lastIndex));
                    sqlSession.commit();
                    index = lastIndex; // 更新每批数据的首条数据下标
                    lastIndex = index + batchCount; // 更新每批数据的末条数据下标
                    System.out.println("起始:" + index + "  " + "结束:" + lastIndex);
                }
            }
        } catch (SqlSessionException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result == 1 ? true : false;
    }
}
