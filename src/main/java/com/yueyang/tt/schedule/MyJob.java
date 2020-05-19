package com.yueyang.tt.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @program: IdleStudy
 * @description:
 *
 * 任务调度类
 * @author: qinxiangyang
 * @create: 2020-05-19 10:25
 **/
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz  myjob date: "+new Date());
    }
}