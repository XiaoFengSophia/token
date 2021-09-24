package com.zxf.designModel.ProxyPattern.Impl;

import com.zxf.designModel.ProxyPattern.Image;

/**
 * @Author: zhaoxiaofeng
 * @Description:测试
 * @Date: 2020/6/23 14:35
 */
public class Test {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
