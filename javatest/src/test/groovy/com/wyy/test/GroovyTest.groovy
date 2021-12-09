package com.wyy.test

import org.junit.jupiter.api.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate

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

    private <T> List<T> random(List<T> list, int count = new SecureRandom().nextInt(list.size()) + 1) {
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

    @Test
    void test() {
        String url = "http://172.20.24.14/api/rest/internal/v1/en/scheduledMeetings/getScheduledParticipantList?scheduledMeetingId=968084de7cd261c6017cdb0b2ab2247a"

        RestTemplate restTemplate = new RestTemplate()
        Map users = restTemplate.getForObject(url, Map.class)
        List ids = users.users*.id

        int start = 0
        int end = 10
        while (end < ids.size()) {
            List idArr = users.users*.id.subList(start,end)
            url = "http://172.20.24.14/api/rest/internal/v1/en/users"
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> request = new HttpEntity<>(idArr, headers);

            def list = restTemplate.postForObject(url, request, List.class)

            list.each {
                if (it.cellPhone.size()>20){
                    println it
                }
            }

            Thread.sleep(200)
            start = end
            end+=10
        }



    }
}
