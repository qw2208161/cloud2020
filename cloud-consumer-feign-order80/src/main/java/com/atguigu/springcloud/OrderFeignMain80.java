package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: 主启动
 *
 * @author 周志钦（zhiqin.zhou@ucarinc.com）
 * @version 1.0
 * @date 2021-06-21 15:14:40
 */
@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
