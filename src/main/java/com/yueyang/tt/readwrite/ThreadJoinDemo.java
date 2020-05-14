package com.yueyang.tt.readwrite;

/**
 * @program: IdleStudy
 * @description: thread  join方法的使用
 * @author: qinxiangyang
 * @create: 2020-05-14 11:42
 **/
public class ThreadJoinDemo {

    public static void main(String[] args) throws Exception {


        ThreadC threadC = new ThreadC();
        ThreadD threadD = new ThreadD();
        ThreadE threadE = new ThreadE();


        threadC.start();
        threadE.join();
        threadD.start();
        threadD.join();
        threadE.start();
        threadC.join();



    }
}

class ThreadC extends Thread {
    @Override
    public void run() {

        for (int i = 0; i <= 2; i++) {
            System.out.println("ThreadC---" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception E) {

            }
        }
    }
}

class ThreadD extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 2; i++) {
            System.out.println("ThreadD---" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception E) {

            }
        }
    }
}

class ThreadE extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 2; i++) {
            System.out.println("ThreadE---" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception E) {

            }
        }
    }
}
