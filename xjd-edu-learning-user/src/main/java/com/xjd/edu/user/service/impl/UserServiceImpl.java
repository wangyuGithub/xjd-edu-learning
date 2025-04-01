package com.xjd.edu.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjd.edu.common.entity.User;
import com.xjd.edu.user.dao.user.UserDao;
import com.xjd.edu.user.entity.user.UserEntity;
import com.xjd.edu.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Override
    public User findByMobile(String mobile) {
        User user = new User();
        UserEntity userEntity = this.baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("phone", mobile));
        BeanUtils.copyProperties(userEntity, user);
        Long userId = userEntity.getId();
        user.setId(userId.intValue());
        return user;
    }

    @Override
    public User findById(Integer id) {
        User user = new User();
        UserEntity userEntity = baseMapper.selectById(id.longValue());
        BeanUtils.copyProperties(userEntity, user);
        Long userId = userEntity.getId();
        user.setId(userId.intValue());
        return user;
    }

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