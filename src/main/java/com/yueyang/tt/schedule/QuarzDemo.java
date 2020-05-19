package com.yueyang.tt.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-19 09:45
 **/
public class QuarzDemo {

    public static void main(String[] args) throws Throwable {
        //创建schedule对象
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //创建jobDetail
        JobDetail jo = JobBuilder.newJob(MyJob.class)
                .withDescription("this is a  ram job")   //定时任务的描述
                .withIdentity("ramJob", "ramGroup")  //jobd的name 和group
                .build();

        //创建trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("触发器")
                .withIdentity("ramTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();


        scheduler.scheduleJob(jo, trigger);

        scheduler.start();

    }
}