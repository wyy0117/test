package com.wyy.test

import org.junit.jupiter.api.Test

import java.security.SecureRandom


/**
 * @Date: 2021/8/18
 * @Author: wyy
 */
class GroovyTest {

    @Test
    void test1() {
        def collect = (1..10).collect({ UUID.randomUUID() })
        println "collect = $collect"

        int count = count(collect.size())
        List<Integer> result = random(collect, count)
        println "result = $result"
    }

    private int count(int max) {
        new SecureRandom().nextInt(max) + 1
    }

    private <T> List<T> random(List<T> list, int count = list.size()) {
        List<T> copyList = new ArrayList<>(list)
        SecureRandom random = new SecureRandom()
        T temp

        count.times {
            int index = random.nextInt(copyList.size() - it) - 1
            println "index = $index"
            temp = copyList[index]
            copyList[index] = copyList[copyList.size() - it - 1]
            copyList[copyList.size() - it - 1] = temp
            println "copyList = $copyList"
        }
        return copyList[-1..-count]
    }
}
