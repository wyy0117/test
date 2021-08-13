package com.wyy.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Date: 2021/8/12
 * @Author: wyy
 */
@RestController
public class TestController {

    /**
     * curl -v -H 'token:abcd' 'http://localhost:8080/get?a=abab'
     * curl -v 'http://localhost:8080/get?a=abab'
     *
     * @param a
     * @param token
     * @return
     */
    @GetMapping("get")
    public String get(@RequestParam String a, @RequestHeader(value = "token") String token) {
        System.out.println("a123 = " + a);
        System.out.println("token = " + token);
        return a;
    }

    /**
     * curl -v -H 'Content-type:application/json' -d '{"username":"a","password":"b"}' 'http://localhost:8000/post'
     *
     * @param userDTO
     * @return
     */
    @PostMapping("post")
    public String post(@RequestBody UserDTO userDTO) {
        System.out.println("userDTO = " + userDTO);
        return userDTO.toString();
    }

    /**
     * curl -v -F 'file=@/Users/wyy/temp/ppt/src/main/java/com/wyy/ppt/dto/UserDTO.java' 'http://localhost:8000/file'
     * @param file
     * @return
     */
    @PostMapping("file")
    public String file(MultipartFile file) {
        System.out.println("file.getSize() = " + file.getSize());
        return "success";
    }

}
