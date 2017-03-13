package com.lee.demo.springboot.common.dao.repository;

import com.lee.demo.springboot.common.dao.domain.TeamDO;

/**
 * 队伍缓存接口
 *
 * Created by hzlifan on 2017/3/13.
 */
public interface TeamRepo {

    void save(TeamDO teamDO);

    TeamDO get(String name);

}
