package com.yueyang.thread.chapter1;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-07-05 15:24
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        //第一种情况
        // ALogin aLogin = new ALogin();
        // aLogin.start();
        // BLogin bLogin = new BLogin();
        // bLogin.start();
        // System.out.println(Thread.currentThread().getId());
        // ALogin aLogin = new ALogin();
        //
        // BLogin bLogin = new BLogin();
        // aLogin.start();
        // bLogin.start();
        // MyThread myThread = new MyThread();
        // myThread.start();
        // Thread.sleep(2000);
        //
        // System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
        SuspendDemo suspendDemo = new SuspendDemo();
        suspendDemo.start();
        Thread.sleep(5000);
        //A端
        suspendDemo.suspend();
        System.out.println("A:  " + System.currentTimeMillis() + "i=" + suspendDemo.getI());
        Thread.sleep(5000);
        System.out.println("A:  " + System.currentTimeMillis() + "i=" + suspendDemo.getI());
        //B
        suspendDemo.resume();
        Thread.sleep(5000);
        //c
        suspendDemo.suspend();
        System.out.println("C:  " + System.currentTimeMillis() + "i=" + suspendDemo.getI());
        Thread.sleep(5000);
        System.out.println("C:  " + System.currentTimeMillis() + "i=" + suspendDemo.getI());
    }

}