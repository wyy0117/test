package com.xylink.cachetest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Cacheable(value = "hello")
    public String hello() {
        System.out.println("TestService.hello");
        return "hello";
    }

}
