package com.lee.demo.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.lee.demo.springboot.SpringBootApp;
import com.lee.demo.springboot.common.model.BookDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * BookController测试类
 *
 * Created by hzlifan on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     *
     * @throws Exception
     */
    @Test
    public void getBook() throws Exception {
        mvc.perform(get("/book/4").contentType(MediaType.TEXT_HTML)).andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    public void addBook() throws Exception {
        BookDTO bookDTO = new BookDTO(55L, "Black Swan", 300, "Nassim Nicholas Taleb");
        String json = JSONObject.toJSONString(bookDTO);
        mvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
            .andExpect(status().isOk()).andDo(print());
    }

}
