package com.lee.demo.springboot.common.dao;

import com.lee.demo.springboot.SpringBootApp;
import com.lee.demo.springboot.common.dao.domain.CompanyDO;
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

import java.util.List;

/**
 * 测试CompanyDAO
 *
 * Created by hzlifan on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
@AutoConfigureMockMvc
public class CompanyDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(CompanyDAOTest.class);

    @Autowired
    private CompanyDAO          companyDAO;

    @Test
    public void testSelect() {
        CompanyDO companyDO = companyDAO.getCompanyByCid(6L);
        logger.info(companyDO.toString());
    }

    @Test
    public void testInsert() {
        CompanyDO companyDO = new CompanyDO(7L, "SF", "delivery");
        companyDAO.addCompany(companyDO);
    }

    @Test
    public void testListSelect() {
        List<CompanyDO> companyList = companyDAO.listCompany();
        for (CompanyDO companyDO : companyList) {
            logger.info(companyDO.toString());
        }
    }

}
