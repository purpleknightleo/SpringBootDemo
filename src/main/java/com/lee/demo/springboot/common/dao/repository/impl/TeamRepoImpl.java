package com.lee.demo.springboot.common.dao.repository.impl;

import com.lee.demo.springboot.common.dao.domain.TeamDO;
import com.lee.demo.springboot.common.dao.repository.BaseRepo;
import com.lee.demo.springboot.common.dao.repository.TeamRepo;
import org.springframework.stereotype.Repository;

/**
 * 球队缓存
 *
 * Created by hzlifan on 2017/3/13.
 */
@Repository
public class TeamRepoImpl extends BaseRepo implements TeamRepo {

    private static final String TAG = "teams";

    @Override
    public void save(TeamDO teamDO) {
        hset(TAG, teamDO.getName(), teamDO);
    }

    @Override
    public TeamDO get(String name) {
        return hget(TAG, name, TeamDO.class);
    }

}
