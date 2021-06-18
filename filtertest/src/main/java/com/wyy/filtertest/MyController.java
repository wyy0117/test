package com.wyy.filtertest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("hello")
    @CheckPermission(scope = CheckPermission.Scope.HOST, tokenIndex = 1)
    public String hello(@RequestParam String a, @RequestHeader("token") String token) {
       ThreadLocal<String> threadLocal =  new ThreadLocal<>();
        return a;
    }
}
