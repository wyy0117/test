package com.wyy.cachetest;

import com.wyy.aoplogparameter.LogParameter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@LogParameter
public class TestService {

    @Cacheable(key = "'hello:'+#abc", cacheNames = "hellom123")
    public User hello(String abc, int a) {
        System.out.println("TestService.hello");
        User user = new User();
        user.setId(1L);
        user.setName("name");
        return user;
    }

}

