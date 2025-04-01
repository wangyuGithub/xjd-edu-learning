package com.xjd.edu.course.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjd.edu.course.dao.user.UserDao;
import com.xjd.edu.course.entity.user.UserEntity;
import com.xjd.edu.course.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<MemberEntity> page = this.page(
//                new Query<MemberEntity>().getPage(params),
//                new QueryWrapper<MemberEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}