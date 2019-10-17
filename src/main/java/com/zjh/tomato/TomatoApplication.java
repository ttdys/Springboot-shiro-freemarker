package com.zjh.tomato;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zjh
 */
@SpringBootApplication
@MapperScan("com.zjh.tomato.dao")
public class TomatoApplication {

    public static void main(String[] args) {
       SpringApplication.run(TomatoApplication.class, args);
    }

}
