package com.yueyang.thread.chapter1;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-07-05 16:13
 **/
public class ALogin extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
        LoginServlet.doPost("a", "aa");
    }

}