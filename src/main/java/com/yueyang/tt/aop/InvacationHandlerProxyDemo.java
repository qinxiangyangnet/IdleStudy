package com.yueyang.tt.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 13:26
 **/
public class InvacationHandlerProxyDemo implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private UserDAO userDAO;


    public UserDAO getProxyInstance(UserDAO userDAO) {
        this.userDAO = userDAO;
        UserDAO proxy = (UserDAO) Proxy.newProxyInstance(this.userDAO.getClass().getClassLoader(), this.userDAO.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务--------------------");

        Object obj = method.invoke(userDAO, args);
        System.out.println("结束事务--------------------");
        return obj;
    }
}