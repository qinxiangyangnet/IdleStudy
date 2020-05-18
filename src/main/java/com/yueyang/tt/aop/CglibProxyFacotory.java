package com.yueyang.tt.aop;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: IdleStudy
 * @description:
 * JDK动态代理机制只能代理实现接口的类，一般没有实现接口的类不能进行代理。cglib就是针对类来实现代理的，它
 * 的原理是对指定目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进
 * 行代理。
 *
 *
 * 使用cglib实现动态代理，完全不受代理类必须实现接口的限制，而且cglib底层采用ASM字节码生成框架，使用字节码
 * 技术生成代理类，比使用java反射效率要高
 *
 * 定义了一个拦截器，在调用目标方法之前，cglib回调MethodInterceptor接口方法拦截，来实现自己的业务逻辑，类似
 * 于JDK中的InvocationHandler接口。
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

                /**
                 * proxy：为cglib动态生成的代理实例
                 * method：为上文中实体类所调用的被代理的方法调用
                 *
                 * args：为method参数数值列表
                 *
                 * methodProxy:为生成代理类对方法的代理引用
                 *
                 * 返回：从代理实例方法调用返回的值
                 */
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