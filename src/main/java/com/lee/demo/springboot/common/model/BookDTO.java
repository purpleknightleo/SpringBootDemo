package com.lee.demo.springboot.common.model;

/**
 * Created by hzlifan on 2017/3/7.
 */
public class BookDTO {

    private String  name;

    private Integer pages;

    private String  author;

    public BookDTO() {
    }

    public BookDTO(String name, Integer pages, String author) {
        this.name = name;
        this.pages = pages;
        this.author = author;
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
        return "name = " + name + ", pages = " + pages + ", author = " + author;
    }

}
