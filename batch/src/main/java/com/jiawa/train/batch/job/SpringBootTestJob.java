//package com.jiawa.train.batch.job;
//
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
////springboot自带的定时任务只适合单体应用，不适合集群（可增加分布式锁）
////无法实时修改状态与策略，必须修改代码
//@Component
//@EnableScheduling
//public class SpringBootTestJob {
////    @Scheduled(cron = "0/5 * * * * ?")
//    public void test(){
//        System.out.println("Test Job");
//    }
//}
