package com.yueyang.tt.readwrite;

import org.junit.Test;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-11 10:56
 **/
public class TestLock {

    @Test
    public void test() {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

        /**
         * 读线程
         */
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    readWriteLockDemo.get();
                }
            }).start();
        }

        /**
         * 写线程
         */

        new Thread(new Runnable() {
            public void run() {
                readWriteLockDemo.set((int)(Math.random()*101));
            }
        },"write").start();

        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
    }
}