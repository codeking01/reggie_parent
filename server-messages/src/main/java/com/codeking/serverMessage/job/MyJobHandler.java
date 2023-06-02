package com.codeking.serverMessage.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyJobHandler {

    @XxlJob("myJobHandler")
    public void myJobHandler() throws Exception {
        XxlJobHelper.log("Hello XXL-Job");
        // 打印一下
        log.info("发表任务·····");
        // 执行任务逻辑
        // ...
        // 如果没有配置日文件的话，会在控制台输出
        XxlJobHelper.log("Job execution completed.");
    }
}
