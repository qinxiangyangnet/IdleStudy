package com.yueyang.tt.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-19 10:08
 **/
public class TimberDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("timber"+new Date());
            }
        },1000,5000);
    }
}