package com.yueyang.tt.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-19 09:21
 **/
@Component
public class ScheduleDemo {


    @Scheduled(cron = "2 35 *  * * *")
    public void scheduleMethod() {
        System.out.println("schedule测试" + new Date());
    }
}