package com.atguigu.springcloud.controller;



import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 支付
 *
 * @author zzq
 * @version 1.0.0
 * @date 2021/06/21 16:11:03
 * @copyright All Rights Reserved.
 */
@RestController
@Slf4j
@RequestMapping("/payment/")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    /*@Resource
    private DiscoveryClient discoveryClient;*/

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("-------------插入结果:[{}]", result);
        int age = 10 / 2;
        System.out.println("a");
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,端口号: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", result);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("-------------查询结果:[{}]", payment);
        int age = 10 / 2;
        System.out.println(age);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口号: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询 ID: " + id, null);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
