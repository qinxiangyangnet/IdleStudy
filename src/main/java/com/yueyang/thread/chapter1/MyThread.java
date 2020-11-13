package com.yueyang.thread.chapter1;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-07-05 16:49
 **/
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5000000; i++) {
            if (i == 5) {
                this.interrupt();
            }
            // if (Thread.interrupted()) {
            //     System.out.println("----------------------停止状态，退出");
            //     break;
            // }
            System.out.println("i=" + (i + 1));
        }
    }

}