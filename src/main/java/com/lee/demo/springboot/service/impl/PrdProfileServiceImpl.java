package com.lee.demo.springboot.service.impl;

import com.lee.demo.springboot.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * 生产环境服务实现类，通过@Profile("prd")表明生产环境处理逻辑
 * 
 * Created by hzlifan on 2017/3/9.
 */
@Service
@Profile("prd")
public class PrdProfileServiceImpl implements ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(PrdProfileServiceImpl.class);

    @Override
    public void send() {
        logger.info("this is prd profile service");
    }

}
