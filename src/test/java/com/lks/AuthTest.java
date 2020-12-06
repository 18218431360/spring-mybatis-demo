package com.lks;

import com.lks.bean.User;
import com.lks.dao.impl.UserMapperImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AuthTest
 * @Description TODO
 * @Author lks
 * @Date 2020/4/19 18:35
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AuthTest {

    @Autowired
    UserMapperImpl userMapper;

    @Test
    public void insertBatch() {
        List<User> list = new ArrayList<User>();
        final int totalCount = 10000000; // 插入的总数量
        final int eachCount = 1000000; // 每次插入的数量
        int j = 0;

        User user;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= totalCount; i++) {
            user = new User();
            user.setUserId(null);
            user.setUserName("用户" + i);
            user.setUserPass("qwe" + i);
            list.add(user);
            j++;
            if (j == eachCount) {
                Boolean insert = userMapper.batchInsert(list);
                list.clear();
                j = 0;
            } else if (i == totalCount) {
                Boolean insert = userMapper.batchInsert(list);
                list.clear();
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("新增" + totalCount + "条数据共耗时: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        int totalCount = 13;
        int eachCount = 5;
        int lastIndex = eachCount;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= totalCount; i++) {
            list.add(i);
            j++;
            if (j == eachCount) {
                System.out.println(list);
                list.clear();
                j = 0;
            } else if (i == totalCount) {
                System.out.println(list);
                list.clear();
            }
        }
    }
}
