package com.yueyang.tt.aop;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 13:12
 **/
public class CglibProxyFacotory {

    private Object obj;

    public CglibProxyFacotory(){}

    public CglibProxyFacotory(Object obj) {
        this.obj = obj;
    }


    public Object getProxy() {
        //Enhancer类是cglib中的一个字节码增强器，它可以方便的为你所要处理的类进行扩展
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("事务开启------------");
                method.invoke(obj, objects);
                System.out.println("事务结束------------");
                return proxy;
            }
        });


        //创建代理对象
        return enhancer.create();
    }



}