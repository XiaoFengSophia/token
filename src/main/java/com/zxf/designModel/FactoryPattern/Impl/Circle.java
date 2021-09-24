package com.zxf.designModel.FactoryPattern.Impl;

import com.zxf.designModel.FactoryPattern.Shape;

/**
 * @Author: zhaoxiaofeng
 * @Description: 对象 Circle
 * @Date: 2020/6/10 21:17
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("画圆圈！");
    }
}
