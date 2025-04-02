package com.xjd.edu.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xjd.edu.api.course.CourseClient;
import com.xjd.edu.api.user.UserClient;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.common.utils.SubjectUtil;
import com.xjd.edu.toolkit.cache.GameRedisTemplate;
import com.xjd.edu.user.dao.course.BookInfoDao;
import com.xjd.edu.user.dao.user.UserDao;
import com.xjd.edu.user.entity.course.BookInfoEntity;
import com.xjd.edu.user.entity.user.UserEntity;
import com.xjd.edu.user.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseClient courseClient;



    @Autowired
    private GameRedisTemplate gameRedisTemplate;


    @RequestMapping("/demo")
    public Object login() {
        List<UserEntity> userList = userDao.selectList(new QueryWrapper<>());
        List<BookInfoEntity> bookInfoList = bookInfoDao.selectList(new QueryWrapper<>());
        Map<String, Object> map = new HashMap<>();
        map.put("userList", userList);
        map.put("bookInfoList", bookInfoList);
        map.put("feign courseClient", courseClient.info());
        return map;
    }


    @RequestMapping("/getUserInfo")
    public Object getUserInfo() {
        // 获取当前用户信息
        User user = (User) SubjectUtil.getCurrentUser();
        System.out.println(user);
        return user;
    }



}
