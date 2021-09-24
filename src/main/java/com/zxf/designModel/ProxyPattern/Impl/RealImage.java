package com.zxf.designModel.ProxyPattern.Impl;

import com.zxf.designModel.ProxyPattern.Image;

/**
 * @Author: zhaoxiaofeng
 * @Description:真正对象
 * @Date: 2020/6/23 14:28
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
