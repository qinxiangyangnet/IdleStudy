package com.yueyang.tt.readwrite;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-14 11:34
 **/
public class YieldExcemple {

    public static void main(String[] args) {


        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);

        threadA.start();
        threadB.start();


    }

}

class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 9; i++) {
            System.out.println("ThreadA---" + i);
            Thread.yield();
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 9; i++) {
            System.out.println("ThreadB---" + i);
            Thread.yield();
        }
    }
}
