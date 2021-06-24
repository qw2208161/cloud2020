package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * description: 自定义负载均衡器
 *
 * @author 周志钦（zhiqin.zhou@ucarinc.com）
 * @version 1.0
 * @date 2021-06-24 16:36:32
 */
public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
