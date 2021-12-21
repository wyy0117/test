package com.wyy.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaTest {

    @Test
    public void test1() {
        int score = 5;

        score |= (1 << 28);
        score |= (1 << 29);

        System.out.println(score << 4 >> 4);
    }

    @Test
    public void test2() {
      new DebugService().test1();
    }

    @Test
    public void test3() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("1", 1);
        map1.put("2", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("1", 1);
        map2.put("3", 3);

        map1.putAll(map2);

        System.out.println(map1);
    }

    @Test
    public void testSort() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("s", 1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("s", 2);

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("s", 3);

        List<Map<String, Integer>> list = Stream.of(map1, map2, map3).sorted(Comparator.comparingInt(m -> m.get("s"))).collect(Collectors.toList());
        System.out.println("list = " + list);
    }

    @Test
    public void version1() {
        String v1 = "3.0.0";
        String v2 = "4.1";
        int res = compareVersion(v1, v2);
        System.out.println("res = " + res);
    }

    private int compareVersion(String v1, String v2) {
        int i = 0, j = 0, x = 0, y = 0;
        int v1Len = v1.length();
        int v2Len = v2.length();
        char c;
        do {
            while (i < v1Len) {//计算出V1中的点之前的数字
                c = v1.charAt(i++);
                if (c >= '0' && c <= '9') {
                    x = x * 10 + (c - '0');//c-‘0’表示两者的ASCLL差值
                } else if (c == '.') {
                    break;//结束
                } else {
                    //无效的字符
                }
            }
            while (j < v2Len) {//计算出V2中的点之前的数字
                c = v2.charAt(j++);
                if (c >= '0' && c <= '9') {
                    y = y * 10 + (c - '0');
                } else if (c == '.') {
                    break;//结束
                } else {
                    //无效的字符
                }
            }
            if (x < y) {
                return -1;
            } else if (x > y) {
                return 1;
            } else {
                x = 0;
                y = 0;
                continue;
            }

        } while ((i < v1Len) || (j < v2Len));
        return 0;
    }

    @Test
    public void testString() {
        String s = "使用小鱼易连手机app，点击右上角”扫一扫“，扫描二维码参与";
        System.out.println(s);
    }

    @Test
    public void test4() {
        new HashMap<>();
    }

    private void print(String s) {
        System.out.println("s = " + s);
    }

    @Test
    public void testStr() {
        String str = "http://172.25.48.130:26001/page/api/rest/internal/v3/vote/token/verify?userId={userId}&conferenceNo={conferenceNo}&meetingId={meetingId}&token={token}";
        String token = "wpIWXgAFnFVdMAtNzzS/d+oHpZvo8RPEEBoaep5u6Jio3e6g9l79DG1QfIr/DVfoM4cqMeVIyjKZeLbyTMA8CA==";
        str = str.replace("{token}", token);
        System.out.println("str = " + str);

    }

    @Test
    public void List() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println("list = " + list);

        Map<String, String> map = new HashMap<>();
        map.computeIfAbsent("aa", __ -> "bb");
    }

    @Test
    public void testMap() {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        map1.put("1", "1");
        map1.put("2", "2");

        map2.put("a", "a");
        map2.put("B", "B");
        List<Iterator> list = new ArrayList();

        list.add(map1.entrySet().iterator());
        list.add(map2.entrySet().iterator());

        for (Iterator iterator : list) {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        System.out.println("map1 = " + map1);

    }

    @Test
    public void lambda() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        for (String s : list) {
            print(s);
        }


        list.forEach((s) -> {
            System.out.println("s = " + s);
        });

        list.forEach((String s) -> {
            System.out.println("111" + s);
        });

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);

        map.forEach((k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });

        List<DTO> result = new ArrayList<>();
        for (String s : list) {

            result.add(new DTO(s));
        }


        List<DTO> collect = list.stream().map(s -> {
                    return new DTO(s);
                }).filter(dto -> {
                    return dto.getA().equals("1");
                })


                .collect(Collectors.toList());


        System.out.println("list = " + list);

    }

    class DTO {
        private String a;

        public DTO(String a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "DTO{" +
                    "a='" + a + '\'' +
                    '}';
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
