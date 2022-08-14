/*
 * @Author: hujiayucc
 * @Date: 2022-08-09 22:47:12
 * @Description: 文件描述
 */
package com.hujiayucc.xlz;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class XlzApplication {
    public static void main(String[] args) {
        SpringApplication.run(XlzApplication.class, args);
    }
}
