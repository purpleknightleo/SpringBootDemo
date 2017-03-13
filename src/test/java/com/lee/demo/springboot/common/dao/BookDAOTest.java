package com.lee.demo.springboot.common.dao;

import com.lee.demo.springboot.SpringBootApp;
import com.lee.demo.springboot.common.dao.domain.BookDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BookDAOImpl测试类，用于测试数据库+缓存
 * 使用方法：
 * 1）启动类加@EnableCaching
 * 2）编写XXXDAOImpl，添加@Cacheable/@CacheInput/@CacheEvict注解
 * 3）配置缓存(不配置会自动使用内置的缓存方案)，这里以EhCache为例，1）添加ehcache依赖 2）编写ehcache.xml
 *
 * 参考：
 * http://blog.didispace.com/springbootcache1/
 * http://blog.csdn.net/whatlookingfor/article/details/51833378
 *
 * Created by hzlifan on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class BookDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(BookDAOTest.class);

    @Autowired
    private BookDAO             bookDAO;

    @Test
    public void testSave() {
        Long bid = 55L;

        // save
        BookDO bookDO = new BookDO(bid, "Black Swan", 300, "Nassim Nicholas Taleb");
        bookDAO.save(bookDO);

        // get from cache
        bookDO = bookDAO.getById(bid);
        logger.info(bookDO.toString());
    }

    /**
     * key值满足缓存条件，第二次查询应从缓存获取
     */
    @Test
    public void testGetValid() {
        Long bid = 13L;
        testGet(bid);
    }

    /**
     * key值不满足缓存条件，第二次查询应从数据库获取
     */
    @Test
    public void testGetInvalid() {
        Long bid = 77777L;
        testGet(bid);
    }

    @Test
    public void testRemove() {
        // remove
        bookDAO.remove(55L);

        // get
        bookDAO.getById(55L);
    }

    private void testGet(Long bid) {
        // first get
        BookDO bookDO = bookDAO.getById(bid);
        logger.info(bookDO.toString());

        // second get
        bookDO = bookDAO.getById(bid);
        logger.info(bookDO.toString());
    }

}
