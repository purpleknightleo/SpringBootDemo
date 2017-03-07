package com.lee.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类(一般放在顶层目录下，所以@SpringBootApplication的scanBasePackages可以不写)
 * 三种方式启动本项目：
 * 1）直接运行该类（启动配置的VM Options中加入-Dspring.profiles.active=dev）
 * 2）终端执行命令"mvn clean package -Dmaven.test.skip=true -Drun.profiles=dev spring-boot:run"
 * 3）终端执行命令"mvn clean package && java -jar target/springboot.jar --spring.profiles.active=dev"
 *
 * Created by hzlifan on 2017/3/1.
 */
@SpringBootApplication //(scanBasePackages = "com.lee.demo.springboot")
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
