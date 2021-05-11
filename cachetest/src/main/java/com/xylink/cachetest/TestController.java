package com.xylink.cachetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * curl -v localhost:8080/hello
     * @return
     */
    @GetMapping("hello")
    public String hello() {
        return testService.hello();
    }
}
