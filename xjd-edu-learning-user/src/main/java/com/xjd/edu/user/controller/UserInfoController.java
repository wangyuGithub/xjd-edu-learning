package com.xjd.edu.user.controller;

import com.xjd.edu.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author wangyu
 * @email wangyu@sina.com
 * @date 2025-03-30 13:01:14
 */
@RestController
@RequestMapping("user/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

}
