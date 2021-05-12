package com.wyy.cachetest;

import com.wyy.aoplogparameter.LogParameter;
import org.springframework.stereotype.Service;


@Service
@LogParameter
public class TestService {

    //    @Cacheable(value = "hello")
    public String hello(String abc, int a) {
        System.out.println("TestService.hello");
        return "hello";
    }

}

