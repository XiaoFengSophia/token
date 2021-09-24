package com.zxf.designModel.FactoryPattern.Impl;

import com.zxf.designModel.FactoryPattern.Shape;

/**
 * @Author: zhaoxiaofeng
 * @Description:对象 Rectangle
 * @Date: 2020/6/10 21:25
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画正方形！");
    }
}
