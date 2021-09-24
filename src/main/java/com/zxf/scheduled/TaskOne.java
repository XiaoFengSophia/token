package com.zxf.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2021/1/30 9:14
 */
@Component
public class TaskOne {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
    public void Task_1() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
        try {
            Thread.sleep(7000);
            System.out.println("------业务处理完毕------" + dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "*/5 * * * * *")
    public void Task_2() {
        System.out.println("这是cron表达式------：" + dateFormat.format(new Date()));
    }

}
