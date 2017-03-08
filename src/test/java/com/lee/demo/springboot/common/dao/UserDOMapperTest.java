package com.lee.demo.springboot.common.dao;

import com.google.common.collect.Maps;
import com.lee.demo.springboot.SpringBootApp;
import com.lee.demo.springboot.common.dao.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 测试UserDOMapper
 *
 * Created by hzlifan on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
@Transactional
public class UserDOMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDOMapperTest.class);

    @Autowired
    private UserDOMapper userDOMapper;

    @Test
    @Rollback(false)
    public void testInsert() {
        UserDO userDO = new UserDO(99L, "Rodman", "1");
        userDOMapper.addUser(userDO);
    }

    @Test
    public void testSelect() {
        UserDO userDO = userDOMapper.getUserById(2L);
        logger.info(userDO.toString());
    }

    @Test
    @Rollback(false)
    public void testDelete() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("uid", 99L);
        userDOMapper.delUser(params);
    }

}
