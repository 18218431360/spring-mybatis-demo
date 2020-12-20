package com.lks.service;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class TestService {

    public static void main(String[] args) {
        String test = "test";
        String testService = "123";
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.forEach(item->{
            System.out.println(item);
        });
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
        System.out.println(testService);
    }
}
