package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务接口实现
 *
 * @author zzq
 * @version 1.0.0
 * @date 2021/06/21 16:11:03
 * @copyright All Rights Reserved.
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Long insertByProperty(Payment payment) {
        return this.paymentMapper.insertByProperty(payment);
    }

    @Override
    public Integer insertBatchByProperty(List<Payment> list) {
        return this.paymentMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Payment payment) {
        return this.paymentMapper.updateByPrimaryKey(payment);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Payment> list) {
        return this.paymentMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return this.paymentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Long> list) {
        return this.paymentMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Payment payment) {
        return this.paymentMapper.deleteByProperty(payment);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return this.paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Payment> selectByProperty(Payment payment) {
        return this.paymentMapper.selectByProperty(payment);
    }

    @Override
    public Long countByProperty(Payment payment) {
        return this.paymentMapper.countByProperty(payment);
    }



    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
