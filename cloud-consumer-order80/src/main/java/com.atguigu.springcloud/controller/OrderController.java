package com.atguigu.springcloud.controller;



import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *  订单
 *
 * @author zzq
 * @version 1.0.0
 * @date 2021/06/21 16:11:03
 * @copyright All Rights Reserved.
 */
@RestController
@Slf4j
public class OrderController {

    /**public static final String PAYMENT_URL = "http://localhost:8001";*/
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    /**访问远程服务模板类*/
    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("-------------查询结果:[{}]", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
