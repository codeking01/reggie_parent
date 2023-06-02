package com.codeking.serverMessage.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderRemindJobHandler {

    private static final long REMIND_INTERVAL = 5 * 60 * 1000; // 5分钟

    private static final long MAX_REMIND_TIME = 15 * 60 * 1000; // 15分钟

    // 设置提醒时间
    private static long remindTime ;

    @XxlJob("orderRemindJob")
    public void orderRemindJob() throws Exception {
        long currentTime = System.currentTimeMillis();
        // 获取订单提交时间，假设为orderSubmitTime
        long orderSubmitTime = getOrderSubmitTime(); // 自行实现获取订单提交时间的逻辑


        // 判断是否在15分钟内
        if (currentTime - orderSubmitTime <= MAX_REMIND_TIME) {
            // 计算距离上一次提醒的时间间隔
            long lastRemindTime = remindTime; // 自行实现获取上一次提醒时间的逻辑
            long elapsedTime = currentTime - lastRemindTime;
            log.info("提醒用户去就餐....");
            // 判断是否到了提醒的时间间隔
            if (elapsedTime >= REMIND_INTERVAL) {
                // 在这里编写提醒逻辑
                log.info("订单关闭！");
                // 发送提醒消息给用户
                // ...

                // 更新上一次提醒时间
                updateLastRemindTime(currentTime); // 自行实现更新上一次提醒时间的逻辑
            }
        }
    }

    private void updateLastRemindTime(long currentTime) {
        remindTime = currentTime;
    }

    private long getOrderSubmitTime() {
        remindTime = System.currentTimeMillis();
        // 获取当前时间
        return remindTime;
    }
}

