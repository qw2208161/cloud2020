package com.atguigu.springcloud.controller;



import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private MyLoadBalancer myLoadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("-------------查询结果:[{}]", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            log.info("-------------返回为：{}",entity.getBody());
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        log.info("-------------instances实例信息为：{}",instances);
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        log.info("-------------选择实例信息为：{}",serviceInstance);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
