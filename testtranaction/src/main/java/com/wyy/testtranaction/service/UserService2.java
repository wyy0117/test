package com.wyy.testtranaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/9/2
 * @Author: wyy
 */
@Service
public class UserService2 {

    @Autowired
    private UserService1 userService1;

    public void insertNoTransaction() {
        userService1.insertInTransaction();
    }
}
