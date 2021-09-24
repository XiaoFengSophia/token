package com.zxf.designModel.CGLIBdynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zhaoxiaofeng
 * @Description:测试类
 * @Date: 2020/6/23 17:00
 */
public class Test {
    public static void main(String[] args) {
        RealWork realWork = new RealWork();
        //创建代理对象
        RealWork proxyObj = (RealWork) new ProxyFactory(realWork).getProxyInstance().create();
        proxyObj.insertInf();
        proxyObj.deleteInf();
        proxyObj.updateInf();
        proxyObj.selectInf();
    }
}
