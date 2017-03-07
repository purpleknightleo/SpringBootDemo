package com.lee.demo.springboot.service.impl;

import com.lee.demo.springboot.service.MiscService;
import org.springframework.stereotype.Service;

/**
 * 各类服务实现类
 *
 * Created by hzlifan on 2017/3/7.
 */
@Service
public class MiscServiceImpl implements MiscService {

    @Override
    public String getName() {
        return "kobe";
    }

}
