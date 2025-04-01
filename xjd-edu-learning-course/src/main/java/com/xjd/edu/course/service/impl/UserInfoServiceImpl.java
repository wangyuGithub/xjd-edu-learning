package com.xjd.edu.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjd.edu.course.dao.user.UserInfoDao;
import com.xjd.edu.course.entity.user.UserInfoEntity;
import com.xjd.edu.course.service.UserInfoService;
import org.springframework.stereotype.Service;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<MemberInfoEntity> page = this.page(
//                new Query<MemberInfoEntity>().getPage(params),
//                new QueryWrapper<MemberInfoEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}