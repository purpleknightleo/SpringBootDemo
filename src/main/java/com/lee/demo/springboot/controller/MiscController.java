package com.lee.demo.springboot.controller;

import com.lee.demo.springboot.service.MiscService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 必须加上@EnableWebMvc才能被JUnit测试
 *
 * Created by hzlifan on 2017/3/1.
 */
@RestController
@EnableWebMvc
public class MiscController {

    private static final Logger logger = LoggerFactory.getLogger(MiscController.class);

    @Autowired
    private Environment         env;

    @Autowired
    private MiscService         miscService;

    /**
     * 获取当前profile名称，@GetMapping = @RequestMapping + GET
     *
     * @return
     */
    @GetMapping(path = "/env/profile")
    public String getActiveProfile() {
        return "active profile : " + env.getProperty("spring.profiles.active");
    }

    /**
     * 通过uid查找name
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/misc/name", method = RequestMethod.GET)
    public String getName(@RequestParam("uid") Long uid) {
        logger.debug("get name, uid = {}", uid);
        return miscService.getName();
    }

}
