package com.lee.demo.springboot.common.dao.impl;

import com.lee.demo.springboot.common.dao.BaseDAO;
import com.lee.demo.springboot.common.dao.BookDAO;
import com.lee.demo.springboot.common.dao.domain.BookDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * 书籍DAO实现类，配合缓存使用
 *
 * Created by hzlifan on 2017/3/9.
 */
@Repository
@CacheConfig(cacheNames = "books")
public class BookDAOImpl extends BaseDAO<BookDO> implements BookDAO {

    private static final String NAMESPACE = "com.lee.demo.springboot.common.dao.BookDAO";

    /**
     * 使用@Cacheable，缓存+数据库配合使用，缓存的key为方法的第一个参数（默认就是），且只缓存key值小于9999的记录
     *
     * @return
     */
    @Override
    @Cacheable(key = "#p0", condition = "#p0 < 9999")
    public BookDO getById(Long bid) {
        return queryForObject(NAMESPACE + ".getByBid", bid);
    }

    /**
     * 使用@CachePut，存入数据库时一并存入缓存（对于Update操作同样适用）
     * 注意返回值必须是Bean，而不能是void
     * 缓存key为bid
     *
     * @param bookDO
     */
    @Override
    @CachePut(key = "#bookDO.getBid()")
    public BookDO save(BookDO bookDO) {
        executeInsert(NAMESPACE + ".save", bookDO);
        return bookDO;
    }

    /**
     * 使用@CacheEvict，删除数据库数据时一并删除缓存
     *
     * @param bid
     */
    @Override
    @CacheEvict
    public void remove(Long bid) {
        executeDelete(NAMESPACE + ".remove", bid);
    }

}
