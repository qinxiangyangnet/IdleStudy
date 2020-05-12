package com.yueyang.tt.readwrite;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-11 10:50
 **/
public class ReadWriteLockDemo {

    //模拟共享资源
    private int number = 0;

    /**
     * 默认非公平的模式
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 读
     */
    public void get() {
        //使用读锁

        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + ":  " + number);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    /**
     * 写
     */
    public void set(int number) {
        readWriteLock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName() + ":  " + number);
        } finally {

            System.out.println("持有写锁，不释放，"+number);
          //  readWriteLock.writeLock().unlock();
        }
    }


}