package com.qianfeng.service.impl;

import com.qianfeng.dao.ClassInfoDao;
import com.qianfeng.entity.ClassInfo;
import com.qianfeng.service.ClassInfoService;
import com.qianfeng.utils.MyUtils;
import com.qianfeng.vo.ClassInfoVo;
import com.qianfeng.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoDao dao;

    @Override
    public ClassInfoVo save(ClassInfo classInfo) {
        ClassInfoVo classInfoVo = MyUtils.exec(dao.save(classInfo) > 0, "新增记录", null);
        return classInfoVo;
    }

    @Override
    public ClassInfoVo queryById(int id) {
        ClassInfo classInfo = dao.queryById(id);
        ClassInfoVo classInfoVo = MyUtils.exec(classInfo != null, "查询详细", classInfo);
        return classInfoVo;
    }

    @Override
    public ClassInfoVo QueryLike(String msg) {
        msg = "%"+ msg +"%";
        List<ClassInfo> list = dao.queryLike(msg);
        ClassInfoVo classInfoVo = MyUtils.exec(true, "", list);
        return classInfoVo;
    }

    @Override
    public PageBean<ClassInfo> queryPage(int page, int size) {
        Long count = dao.queryCount();
        List<ClassInfo> list = dao.queryByPage((page - 1) * size, size);
        PageBean<ClassInfo> pageBean = MyUtils.exec(page, size, count, list);
        return pageBean;
    }
}
