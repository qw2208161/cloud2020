package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
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
public class demo2 {
    private static final SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static AtomicInteger atomicInteger3 = new AtomicInteger(200);
    //@Scheduled(fixedRate = 1000)
    public void scheduledDemo(){
        System.out.println(atomicInteger3.getAndDecrement());
    }

    //@Scheduled(fixedRate = 1000)
    public void scheduledDemo1(){
        System.out.println(atomicInteger3.getAndIncrement());
    }

    //@Scheduled(fixedRate = 100)
    public void scheduledDemo2(){
        System.out.println(atomicInteger3.getAndIncrement());
    }

    //@Scheduled(fixedRate = 100)
    public void scheduledDemo3(){
        System.out.println(atomicInteger3.getAndIncrement());
    }
}