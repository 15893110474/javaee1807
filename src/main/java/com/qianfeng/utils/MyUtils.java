package com.qianfeng.utils;

import com.qianfeng.content.SystemCon;
import com.qianfeng.vo.ClassInfoVo;
import com.qianfeng.vo.PageBean;

import java.util.List;

public class MyUtils {

    public static ClassInfoVo exec(boolean istrue,String msg,Object data){
        ClassInfoVo vo = new ClassInfoVo();
        if (istrue){
            vo.setCode(SystemCon.OK);
        } else {
            vo.setCode(SystemCon.ERROR);
        }
        vo.setMsg(msg);
        vo.setDate(data);
        return  vo;
    }

    public static <T>PageBean<T> exec(int page, int size, long count, List<T> data){
        PageBean bean = new PageBean();
        bean.setPage(page);
        bean.setSize(size);
        bean.setCount(count);
        bean.setTotalPage((int)(count%size==0?count/size:count/size + 1));
        bean.setData(data);
        return  bean;
    }
}
