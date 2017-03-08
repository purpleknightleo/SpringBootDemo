package com.lee.demo.springboot.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 各类配置属性，配置在application*.properties中
 *
 * Created by hzlifan on 2017/3/8.
 */
@Component
public class MiscProperties {

    @Value("${projectUrl}")
    private String  projectUrl;

    @Value("${user.id}")
    private Integer userId;

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
