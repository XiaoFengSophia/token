package com.zxf.designModel.JDKdynamic.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zhaoxiaofeng
 * @Description:代理工厂
 * @Date: 2020/6/23 15:31
 */
public class ProxyFactory {
    private Object object; // 目标对象

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new InvocationHandler() {
                    // proxy:表示我们代理的真实对象
                    // method:表示调用真实对象中的某个方法的metode对象
                    // args:调用真实对象方法里所传的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub
                        //在代理真实对象前我们可以添加一些自己的操作
                        System.out.println("调用方法前执行！");
                        //目标方法调用
                        Object obj = method.invoke(object, args);
                        System.out.println("方法执行完毕！");
                        return obj;
                    }
                });
    }
}
