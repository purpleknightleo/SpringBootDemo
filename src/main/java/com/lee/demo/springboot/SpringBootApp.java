package com.lee.demo.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.lee.demo.springboot.common.config.MusicProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

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
@EnableConfigurationProperties(MusicProperties.class)
@EnableCaching
@EnableScheduling
public class SpringBootApp {

    /**
     * 使用fastjson作为序列化工具
     * 参考：http://412887952-qq-com.iteye.com/blog/2315202
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter4 fastConverter = new FastJsonHttpMessageConverter4();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
