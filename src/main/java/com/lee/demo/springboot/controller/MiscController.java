package com.lee.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 必须加上@EnableWebMvc才能被JUnit测试
 *
 * Created by hzlifan on 2017/3/1.
 */
@RestController
@EnableWebMvc
public class MiscController {

    /**
     * index page
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "Welcome to SpringBoot Demo by Fernando Lee";
    }

    /**
     * 通过uid查找name
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/misc/name", method = RequestMethod.GET)
    public String getName(@RequestParam("uid") Long uid) {
        return "hello";
    }

}
