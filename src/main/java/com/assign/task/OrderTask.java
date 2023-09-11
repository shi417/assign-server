package com.assign.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTask {

    @Scheduled(fixedRate = 300000) // 每5分钟执行一次，以毫秒为单位
    public void fetchOrders() {
        // 执行你的任务代码
        System.out.println("定时任务执行了！");
    }

}
