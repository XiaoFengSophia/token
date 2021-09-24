package com.zxf.designModel.JDKdynamic.test;

import com.zxf.designModel.JDKdynamic.Impl.RealWork;
import com.zxf.designModel.JDKdynamic.PrepareWork;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zhaoxiaofeng
 * @Description:测试类
 * @Date: 2020/6/23 15:17
 */
public class Test {
    public static void main(String[] args) {
        // 1.要代理的真实对象
        RealWork prepareWork = new RealWork();//
        PrepareWork proxy = (PrepareWork) new ProxyFactory(prepareWork).getProxyInstance();
        proxy.openCompare();
        System.out.println("-----------------------------分隔符-----------------------------");
        proxy.LuCode("PAYTHON");
    }
}
