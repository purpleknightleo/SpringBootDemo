package com.lee.demo.springboot.common.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by hzlifan on 2017/3/7.
 */
public class BookDTO {

    /**
     * 该字段不参与序列化，反序列化由deserialize属性控制
     */
    @JSONField(serialize = false)
    private Long    bid;

    private String  name;

    private Integer pages;

    private String  author;

    public BookDTO() {
    }

    public BookDTO(Long bid, String name, Integer pages, String author) {
        this.bid = bid;
        this.name = name;
        this.pages = pages;
        this.author = author;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "bid = " + bid + ", name = " + name + ", pages = " + pages + ", author = " + author;
    }

}
