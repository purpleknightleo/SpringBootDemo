package com.lee.demo.springboot.common.dao.domain;

import java.io.Serializable;

/**
 * 球队DO
 *
 * Created by hzlifan on 2017/3/13.
 */
public class TeamDO implements Serializable {

    private String name;

    private String city;

    public TeamDO() {
    }

    public TeamDO(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "name = " + name + ", city = " + city;
    }

}
