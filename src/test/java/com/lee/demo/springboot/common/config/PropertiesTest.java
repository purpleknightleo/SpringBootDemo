package com.lee.demo.springboot.common.config;

import com.lee.demo.springboot.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试Properties配置(application.properties中各环境共享的，以及application-XXX.properties中各环境独立配置的)
 *
 * Created by hzlifan on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class PropertiesTest {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesTest.class);

    @Autowired
    private MiscProperties      miscProperties;

    @Test
    public void test() {
        logger.info("projectUrl = {}", miscProperties.getProjectUrl());
        logger.info("user.id = {}", miscProperties.getUserId());
    }

}
