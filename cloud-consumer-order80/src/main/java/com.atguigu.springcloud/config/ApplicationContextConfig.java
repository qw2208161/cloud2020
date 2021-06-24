package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * description: 消费者只关心微服务名称.
 *
 * @author 周志钦（zhiqin.zhou@ucarinc.com）
 * @version 1.0
 * @date 2021-06-21 22:05:32
 */
@Configuration
public class ApplicationContextConfig {

//    @LoadBalanced //注销掉是 为了试验自己写的rule,此时其它接口暂时不能用,测试方法 http://localhost/consumer/payment/lb
    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
