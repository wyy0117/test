package com.wyy.cachetest;

import com.wyy.aoplogparameter.LogParameter;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @LogParameter
//    @Cacheable(value = "hello")
    public String hello(String abc,int a) {
        System.out.println("TestService.hello");
        return "hello";
    }

}
