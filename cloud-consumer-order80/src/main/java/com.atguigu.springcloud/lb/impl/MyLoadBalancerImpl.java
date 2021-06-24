package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: 实现类
 *
 * @author 周志钦（zhiqin.zhou@ucarinc.com）
 * @version 1.0
 * @date 2021-06-24 16:37:21
 */
@Component
public class MyLoadBalancerImpl implements MyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 负载均衡算法: rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标.每次服务重启动后rest接口计数从1开始。
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }


    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            //Integer 最大值2147483647
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("---------第几次访问,次数:next=" + next);
        return next;
    }
}
