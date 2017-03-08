package com.lee.demo.springboot.common.dao;

import com.lee.demo.springboot.common.dao.domain.UserDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 用户Mapper（不通过XXXMapper.xml，直接利用注解配置SQL）
 *
 * Created by hzlifan on 2017/3/8.
 */
@Mapper
public interface UserDOMapper {

    String TABLE_NAME = "user";

    /**
     * 根据uid查找用户
     * 其中@Results/@Result用于属性与列名的映射（如果两者相同可不写）
     * 参数为@Param修饰的基本参数
     *
     * @param uid
     * @return
     */
    @Results({ @Result(property = "uid", column = "uid"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password") })
    @Select("select * from " + TABLE_NAME + " where uid = #{uid}")
    UserDO getUserById(@Param("uid") Long uid);

    /**
     * 添加用户
     * 其中SQL语句采用了@InsertProvider的形式注入
     * 参数为Bean
     * @param userDO
     */
    @InsertProvider(type = SqlBuilder.class, method = "genInsertSql")
    void addUser(UserDO userDO);

    /**
     * 删除用户
     * 参数为Map
     *
     * @param params
     */
    @Delete("delete from " + TABLE_NAME + " where uid = #{uid}")
    void delUser(Map<String, Object> params);

    /**
     * SQL语句构建类
     */
    class SqlBuilder {

        public String genInsertSql() {
            return new SQL().INSERT_INTO(TABLE_NAME).VALUES("uid", "#{uid}")
                .VALUES("name", "#{name}").VALUES("password", "#{password}").toString();
        }
    }

}
