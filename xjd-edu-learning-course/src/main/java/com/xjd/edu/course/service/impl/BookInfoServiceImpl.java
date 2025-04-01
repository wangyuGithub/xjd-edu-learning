package com.xjd.edu.course.service.impl;

import com.xjd.edu.course.dao.course.BookInfoDao;
import com.xjd.edu.course.entity.course.BookInfoEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xjd.edu.course.service.BookInfoService;


@Service("bookInfoService")
public class BookInfoServiceImpl extends ServiceImpl<BookInfoDao, BookInfoEntity> implements BookInfoService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<BookInfoEntity> page = this.page(
//                new Query<BookInfoEntity>().getPage(params),
//                new QueryWrapper<BookInfoEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}