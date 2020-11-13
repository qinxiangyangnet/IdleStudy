package com.yueyang.thread.chapter1;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-07-05 16:09
 **/
public class LoginServlet {

    private static String userNameRef;
    private static String passwordRef;

    public static void doPost(String userName, String password) {
        try {
            System.out.println(Thread.currentThread().getId());
            userNameRef = userName;
            if (userName.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println(userNameRef + "::  " + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}