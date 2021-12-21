package com.wyy.testtranaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = {"classpath:application.properties", "classpath:config.yml"})
public class TesttranactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesttranactionApplication.class, args);
    }

}
