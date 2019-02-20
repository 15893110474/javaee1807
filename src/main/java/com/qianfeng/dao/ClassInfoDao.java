package com.qianfeng.dao;

import com.qianfeng.entity.ClassInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassInfoDao {

    //新增
    @Insert("insert into classinfo(name,question,res,className,time) values(#{name),#{question},#{res},#{className},now())")
    int save(ClassInfo classInfo);
    //查询详情
    @Select("select id,name,question,res,className,time from classinfo where id = #{id}")
    @ResultType(ClassInfo.class)
    ClassInfo queryById(int id);
    //查询分页
    @Select("select id,name,question,res,className,time from classinfo limit #{index},#{size}")
    @ResultType(ClassInfo.class)
    List<ClassInfo> queryByPage(@Param("index") int index , @Param("size") int size);
    //查询数量
    @Select("select count(*) from classinfo")
    @ResultType(Long.class)
    Long queryCount();
    //模糊查询
    @Select("select id,name,question,res,className,time from classinfo where name like #{msg} or question like #{msg}")
    @ResultType(ClassInfo.class)
    List<ClassInfo> queryLike(String msg);

}
