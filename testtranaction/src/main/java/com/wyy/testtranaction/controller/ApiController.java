package com.wyy.testtranaction.controller;

import com.wyy.testtranaction.service.UserService1;
import com.wyy.testtranaction.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/9/2
 * @Author: wyy
 */
@RestController
public class ApiController {
    @Autowired
    private UserService1 userService1;

    @Autowired
    private UserService2 userService2;

    @GetMapping("test")
    public void test() {
//        userService1.insertNoTransaction();
        userService2.insertNoTransaction();
    }
}
