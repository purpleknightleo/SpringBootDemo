package com.lee.demo.springboot.controller;

import com.lee.demo.springboot.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * MiscController的测试类
 * 需要在@SpringBootTest中把关联的Controller传入
 *
 * Created by hzlifan on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class MiscControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     *
     * @throws Exception
     */
    @Test
    public void getName() throws Exception {
        mvc.perform(
            get("/misc/name").contentType(MediaType.TEXT_HTML)
                .param("uid", "123")).andExpect(status().isOk())
            .andExpect(content().string(equalTo("kobe")));
    }

}
