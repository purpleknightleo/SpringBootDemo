package com.lee.demo.springboot.controller;

import com.lee.demo.springboot.common.model.BookDTO;
import com.lee.demo.springboot.common.utils.PackUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * 书籍控制类（用于测试Swagger2自动生成API文档）
 *
 * Created by hzlifan on 2017/3/7.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    /**
     * 添加书籍（与Swagger2关联）
     *
     * @param bookDTO
     * @return
     */
    @PostMapping(path= "")
    @ApiOperation(value="添加书籍", notes="添加书籍")
    @ApiImplicitParam(name = "bookDTO", value = "书籍实体", required = true, dataType = "BookDTO")
    public Map<String, Object> addBook(@RequestBody BookDTO bookDTO) {
        try {
            logger.info("add book, " + bookDTO);
            return PackUtils.genSuccessResponse();
        } catch (Exception e) {
            logger.error("fail to add book", e);
        }
        return PackUtils.genErrorResponse(300, "internal error");
    }

    /**
     * 忽略Swagger2
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "/{id}")
    @ApiIgnore
    public Map<String, Object> delBook(@PathVariable("id") Integer id) {
        try {
            logger.info("delete book, id = {}" ,id);
            return PackUtils.genSuccessResponse();
        } catch (Exception e) {
            logger.error("fail to delete book", e);
        }
        return PackUtils.genErrorResponse(300, "internal error");
    }

}
