package com.lee.demo.springboot.common.dao;

import com.lee.demo.springboot.common.dao.domain.BookDO;

/**
 * 书籍DAO接口
 *
 * Created by hzlifan on 2017/3/9.
 */
public interface BookDAO {

    BookDO getById(Long bid);

    BookDO save(BookDO bookDO);

    void remove(Long bid);

}
