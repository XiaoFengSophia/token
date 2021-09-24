package com.zxf.designModel.JDKdynamic.Impl;

import com.zxf.designModel.JDKdynamic.PrepareWork;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/6/23 15:15
 */
public class RealWork implements PrepareWork {
    @Override
    public void openCompare() {
        System.out.println("open computer......！");
    }

    @Override
    public void LuCode(String language) {
        System.out.println("今天用" + language +"撸代码");
    }
}
