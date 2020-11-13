package com.yueyang.thread.tongxin;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-09-16 20:43
 **/
public class ThreadCAS {

    enum EnumThread {
        T1,
        T2
    }

    ;

    static EnumThread r = EnumThread.T1;

    public static void main(String[] args) {
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();
        new Thread(() ->
        {
            for (char c : c1) {
                while (!r.equals(EnumThread.T1)) {
                }
                System.out.println(c);
                r = EnumThread.T2;
            }
        }, "t1").start();
        new Thread(() ->
        {
            for (char c : c2) {
                while (!r.equals(EnumThread.T2)) {
                }
                System.out.println(c);
                r = EnumThread.T1;
            }
        }, "t2").start();
    }

}