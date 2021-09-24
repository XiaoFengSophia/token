package com.zxf.designModel.ProxyPattern.Impl;

import com.zxf.designModel.ProxyPattern.Image;

/**
 * @Author: zhaoxiaofeng
 * @Description:代理对象
 * @Date: 2020/6/23 14:31
 */
public class ProxyImage implements Image {
    private RealImage realImage; // 被代理的对象
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
