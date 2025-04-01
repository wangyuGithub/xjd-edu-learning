package com.xjd.edu.course.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xjd.edu.api.user.UserClient;
import com.xjd.edu.course.entity.course.BookInfoEntity;
import com.xjd.edu.course.entity.user.UserEntity;
import com.xjd.edu.course.service.BookInfoService;
import com.xjd.edu.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:01:14
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserClient userClient;

    @RequestMapping("/demo")
    public Object demo() {
        List<UserEntity> userList = userService.list();
        List<BookInfoEntity> bookList = bookInfoService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("user", userList);
        map.put("book", bookList);
        map.put("feign", userClient.info("name", 1L));
        return map;
    }

}
