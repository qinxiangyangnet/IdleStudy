package com.yueyang.tt.schedule;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-19 10:13
 **/
public class ScheduleThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(6);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{

            System.out.println("ScheduledThreadPoolExecutor"+new Date());
        },1,2, TimeUnit.SECONDS);
    }
}