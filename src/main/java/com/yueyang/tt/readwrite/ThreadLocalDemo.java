package com.yueyang.tt.readwrite;

import org.junit.Test;

/**
 * @program: IdleStudy
 * @description: 本地线程重写
 * @author: qinxiangyang
 * @create: 2020-05-12 21:44
 **/
public class ThreadLocalDemo {
    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws Exception {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }


    @Test
    public void test() {

         ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
         threadLocal.set(1);
         threadLocal.set(2);
        System.out.println(threadLocal.get());

    }


}