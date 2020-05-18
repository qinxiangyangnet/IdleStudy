package com.yueyang.tt.aop;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 13:20
 **/
public class Test {
    @org.junit.Test
    public void test() {
        UserDAOImpl userDAO = new UserDAOImpl();
        UserDAOImpl proxy = (UserDAOImpl) (new CglibProxyFacotory(userDAO).getProxy());
        proxy.save();
        System.out.println("userDao" + userDAO.getClass());
        System.out.println("proxy" + proxy.getClass());
    }
}