package com.lee.demo.springboot.common.dao.repository;

import com.lee.demo.springboot.SpringBootApp;
import com.lee.demo.springboot.common.dao.domain.TeamDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TeamRepo测试类，用于测试Redis
 *
 * 使用方法：
 * 1）添加依赖spring-boot-starter-data-redis
 * 2）application.properties中配置redis基本属性
 * 3）编写RedisConfig.java，指定各类Serializer
 * 4）编写XXXRepo接口和实现类
 *
 * Created by hzlifan on 2017/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class TeamRepoTest {

    private static final Logger logger = LoggerFactory.getLogger(TeamRepoTest.class);

    @Autowired
    private TeamRepo            teamRepo;

    @Test
    public void test() {
        String name = "Lakers";
        TeamDO teamDO = new TeamDO(name, "LA");
        teamRepo.save(teamDO);

        teamDO = teamRepo.get(name);
        logger.info(teamDO.toString());
    }

}
