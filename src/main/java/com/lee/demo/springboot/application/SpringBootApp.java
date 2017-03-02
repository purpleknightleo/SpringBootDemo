package com.lee.demo.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类
 * 三种方式启动本项目：
 * 1）直接运行该类
 * 2）终端执行命令"mvn spring-boot:run"
 * 3）终端执行命令"mvn clean package && java -jar target/springboot.jar"
 *
 * Created by hzlifan on 2017/3/1.
 */
@SpringBootApplication(scanBasePackages = "com.lee.demo.springboot.controller")
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
