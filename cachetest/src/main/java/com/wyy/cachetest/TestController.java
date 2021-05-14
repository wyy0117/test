package com.wyy.cachetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * curl -v localhost:8001/hello
     *
     * @return
     */
    @GetMapping("hello")
    public User hello() {
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.debug("111");

        return testService.hello("112233", 789);
    }
}
