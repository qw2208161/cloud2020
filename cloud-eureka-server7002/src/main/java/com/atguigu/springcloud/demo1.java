package com.atguigu.springcloud;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author zhqin.zhou
 * @date 2021/8/10 19:34
 * @description demo1
 */
@Slf4j
@Component
public class demo1 {
    private static final SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static int count=6800;
    public static AtomicInteger atomicInteger1 = new AtomicInteger(45600);
    public static AtomicInteger atomicInteger2 = new AtomicInteger(45800);
    public static AtomicInteger atomicInteger3 = new AtomicInteger(200);
    //@Scheduled(fixedRate = 100)
    public void scheduledDemo(){
        //Logger logger =LoggerFactory.getLogger(demo1.class);
        String str = "update ffp_wx_86 set batch = %d where id > %d and id <= %d and updated = 0;";
        String userInfo=String.format(str,atomicInteger3.get(),atomicInteger1.get(),atomicInteger2.get());
       // System.out.println(userInfo);
        log.info(userInfo);
        atomicInteger1.getAndAdd(200);
        atomicInteger2.getAndAdd(200);
        atomicInteger3.getAndAdd(1);
    }
}