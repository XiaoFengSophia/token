package com.zxf.designModel.CGLIBdynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/6/23 17:04
 */
public class ProxyFactory {
    // 被代理对象
    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Enhancer getProxyInstance(){
        //创建cglib核心对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(object.getClass());
        //设置回调
        enhancer.setCallback(new org.springframework.cglib.proxy.MethodInterceptor() {
        /**
         * 当你调用目标方法时，实质上是调用该方法
         * intercept四个参数：
         * proxy:代理对象
         * method:目标方法
         * args：目标方法的形参
         * methodProxy:代理方法
         */
        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            // TODO Auto-generated method stub
            System.out.println("场景一： 记录日志 ");
            System.out.println("场景二： 监控方法运行时间 (监控性能)");
            System.out.println("场景三： 权限控制 ");
            System.out.println("场景四： 缓存优化 (第一次调用查询数据库，将查询结果放入内存对象， 第二次调用， 直接从内存对象返回，不需要查询数据库 )");
            System.out.println("场景五： 事务管理 (调用方法前开启事务， 调用方法后提交关闭事务 ) ");
            Object result = methodProxy.invokeSuper(proxy, args);
            return result;
        }
        });
        return enhancer;
    }
}
