package com.yueyang.thread.tongxin;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-09-16 20:28
 **/
public class ThreadLockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();
        t1 = new Thread(() ->
        {
            for (char c : c1) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() ->
        {
            for (char c : c2) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
    }

}