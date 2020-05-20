package com.yueyang.tt.schedule.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-19 11:14
 **/
@Component
@Slf4j
@JobHandler(value = "testPrint")
public class SoutHandler extends IJobHandler implements Serializable {

private  static Logger  logger= LoggerFactory.getLogger(SoutHandler.class);
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("xxlJOb调度测试---------------" + new Date(),param);
        System.out.println("xxlJOb---------------" + new Date()+param);
        logger.info("xxlJOb---------------" + new Date()+param);
        return ReturnT.SUCCESS;
    }
}