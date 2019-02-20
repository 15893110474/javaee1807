package com.qianfeng.service;

import com.qianfeng.entity.ClassInfo;
import com.qianfeng.vo.ClassInfoVo;
import com.qianfeng.vo.PageBean;

public interface ClassInfoService {

    ClassInfoVo save(ClassInfo classInfo);
    ClassInfoVo queryById(int id);
    ClassInfoVo QueryLike(String msg);
    PageBean<ClassInfo> queryPage(int page,int size);

}
