package com.lks.service;

import com.lks.dto.Course;

public class UserService {

    public static void main(String[] args) {
        Course course = new Course();
        course.setId(1);
        course.setName("计算机组成原理");
        course.setUrl("http://www.jd.com");
        course.setType(1);
        System.out.println(course.toString());
    }
}
