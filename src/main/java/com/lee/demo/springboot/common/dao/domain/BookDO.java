package com.lee.demo.springboot.common.dao.domain;

/**
 * 书籍DO
 *
 * Created by hzlifan on 2017/3/9.
 */
public class BookDO {

    private Long    bid;

    private String  name;

    private Integer pages;

    private String  author;

    public BookDO() {
    }

    public BookDO(Long bid, String name, Integer pages, String author) {
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
