package com.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.ConfigService;
import com.service.GoodslistService;

@Component
public class Job {
	private static final Logger bizLogger = LoggerFactory.getLogger(Job.class);
	
//    public final static long ONE_Minute =  60 * 1000;
    
	@Autowired
	private ConfigService configService;
	@Autowired
	private GoodslistService goodslistService;
    
//    @Scheduled(fixedDelay=ONE_Minute)
//    public void fixedDelayJob(){
//        System.out.println(" >>fixedDelay执行....");
//    }
    
//    @Scheduled(fixedRate=ONE_Minute)
//    public void fixedRateJob(){
//        System.out.println(" >>fixedRate执行....");
//    }

    @Scheduled(cron="0 0 4 * * 1-5")
    public void updateOrderDueTime(){
    	bizLogger.info(" >>updateOrderDueTime执行result="+ configService.updateOrderDueTime());
    }
    
    @Scheduled(cron="0 1 4 * * 2-5")
    public void updateGoodslistStatus(){
    	bizLogger.info(" >>updateGoodslistStatus执行result="+ goodslistService.updateGoodslistStatus());
    }
}