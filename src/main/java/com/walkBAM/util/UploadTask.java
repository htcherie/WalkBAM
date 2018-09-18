package com.walkBAM.util;

import com.walkBAM.service.TicketService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

public class UploadTask extends QuartzJobBean {
    @Resource
    private TicketService ts;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务开始");
        ts.findCar();
        ts.findTrain();
        ts.findPlane();
        System.out.println("任务结束");
    }
}