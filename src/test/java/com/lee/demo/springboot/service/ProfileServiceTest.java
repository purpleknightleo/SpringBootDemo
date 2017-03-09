package com.lee.demo.springboot.service;

import com.lee.demo.springboot.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ProfileService测试，用于测试不同profile下独立的处理逻辑
 * 参考：http://412887952-qq-com.iteye.com/blog/2307104
 *
 * Created by hzlifan on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class ProfileServiceTest {

    @Autowired
    private ProfileService emailService;

    @Test
    public void testProfile() {
        emailService.send();
    }

}
