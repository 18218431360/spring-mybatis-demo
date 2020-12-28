package com.lks.service;

import com.lks.dto.Course;

public class UserService {

    public static void main(String[] args) {
        Course course = new Course();
        course.setId(1);
        course.setName("计算机组成原理");
        course.setUrl("http://www.baidu.com");
        course.setType(1);
        String test1 = "love you too !";
        String test3 = "3";
        System.out.println(course.toString());
    }
}
