package com.wyy.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class JavaTest {

    @Test
    public void test1(){
        int score = 5;

        score|=(1<<28);
        score|=(1<<29);

        System.out.println(score<<4>>4);
    }

    @Test
    public void test2() {
        int sum = Stream.of(1, 2, null).mapToInt(a -> a).sum();
        System.out.println("sum = " + sum);
    }

    @Test
    public void test3() {
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("1",1);
        map1.put("2",2);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("1",1);
        map2.put("3",3);

        map1.putAll(map2);

        System.out.println(map1);
    }
}
