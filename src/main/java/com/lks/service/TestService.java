package com.lks.service;

import java.util.ArrayList;
import java.util.List;

public class TestService {

    public static void main(String[] args) {
        String test = "test";
        String testService = "123";
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.forEach(item->{
            System.out.println(item);
        });
        System.out.println(testService);
    }
}
