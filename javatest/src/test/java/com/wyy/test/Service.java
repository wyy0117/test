package com.wyy.test;

/**
 * @Date: 2021/12/14
 * @Author: wyy
 */
public class Service {

    public void test1() {
        System.out.println("Service.test1");
        test2();
    }

    private void test2() {
        System.out.println("Service.test2");
    }
}
