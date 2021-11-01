package com.atguigu.springcloud;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @author zhqin.zhou
 * @date 2021/8/10 19:34
 * @description demo1
 */
@Component
public class demo1 {
    private static final SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void scheduledDemo(){
        System.out.println("scheduled - fixedRate - print time every 5 seconds:{}" );
    }
}