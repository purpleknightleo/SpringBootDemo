package com.lee.demo.springboot.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 歌曲相关属性（不需要每个属性都有@Value来标注，直接利用统一前缀匹配配置文件中的属性项）
 * 参考：
 * http://412887952-qq-com.iteye.com/blog/2292728
 * http://412887952-qq-com.iteye.com/blog/2307104
 *
 * 使用方法：
 * 1）pom.xml中添加依赖spring-boot-configuration-processor
 * 2）启动主类中添加类注解@EnableConfigurationProperties(MusicProperties.class)
 * 3）属性类添加类注解@ConfigurationProperties(prefix = "music")
 *
 * Created by hzlifan on 2017/3/9.
 */
@ConfigurationProperties(prefix = "music")
public class MusicProperties {

    private Long   id;

    private String name;

    private String singer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

}
