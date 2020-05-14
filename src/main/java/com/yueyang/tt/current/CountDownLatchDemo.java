package com.yueyang.tt.current;

/**
 * @program: IdleStudy
 * @description: CountDownLatch 的作用是：当一个线程需要另外一个或多个线程完成后，再开始执行。比如主线程要等待一个子线程完成环境相关配置的加载工作\
 * ，主线程才继续执行，就可以利用 CountDownLatch 来实现。
 *
 *
 * 首先是创建实例 CountDownLatch countDown = new CountDownLatch(2)
 * 需要同步的线程执行完之后，计数-1； countDown.countDown()
 * 需要等待其他线程执行完毕之后，再运行的线程，调用 countDown.await()实现阻塞同步
 *
 *
 * @author: qinxiangyang
 * @create: 2020-05-14 16:40
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws
            Exception {


        CountDownLatchRe countDownLatch = new CountDownLatchRe(2);
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();//计数器值每次减去1
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();

        countDownLatch.await();// 減去为0,恢复任务继续执行
        System.out.println("两个子线程执行完毕....");
        System.out.println("主线程继续执行.....");
        for (int i = 0; i < 10; i++) {
            System.out.println("main,i:" + i);
        }
    }

}