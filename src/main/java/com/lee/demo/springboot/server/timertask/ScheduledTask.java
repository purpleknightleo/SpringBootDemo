package com.lee.demo.springboot.server.timertask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务（启动主类需要添加@EnableScheduling）
 *
 * Created by hzlifan on 2017/3/13.
 */
@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    /**
     * 定时执行，其中fixedRate为上次执行开始到本次执行的间隔，fixedDelay为上次执行结束到本次执行的间隔，也可以直接用cron表达式
     *
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 20000)
    //    @Scheduled(cron = "...")
    public void printCurTime() {
        logger.info("current time is " + System.currentTimeMillis());
    }

}
