package com.wyy.cachetest;

import com.wyy.aoplogparameter.EnableLogParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableLogParameter
public class CachetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachetestApplication.class, args);
	}

}
