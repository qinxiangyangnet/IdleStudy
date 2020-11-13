package com.yueyang.thread.chapter1;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-07-05 16:35
 **/
public class Test1 {

    public void a() {
        b();
    }

    public void b() {
        c();
    }

    public void c() {
        d();
    }

    public void d() {
        e();
    }

    public void e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            System.out.println(
                stackTraceElement.getClassName() + "  " + stackTraceElement.getMethodName() + " " + stackTraceElement
                    .getLineNumber() + stackTraceElement.getFileName());
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.a();
    }

}