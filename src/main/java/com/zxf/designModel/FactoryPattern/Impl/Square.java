package com.zxf.designModel.FactoryPattern.Impl;

import com.zxf.designModel.FactoryPattern.Shape;

/**
 * @Author: zhaoxiaofeng
 * @Description:对象 Square
 * @Date: 2020/6/10 21:22
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画正方形！");
    }
}
