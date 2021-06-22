package com.atguigu.springcloud.mapper;
import java.util.List;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据接口
 *
 * @author zzq
 * @version 1.0.0
 * @date 2021/06/21 16:11:03
 * @copyright All Rights Reserved.
 */
@Mapper
public interface PaymentMapper {

    /**
     * 根据对象属性插入
     *
     * @param payment 实例对象
     * @return {@link Integer}
     */
    Long insertByProperty(Payment payment);

    /**
     * 根据对象列表属性插入
     *
     * @param list 实例列表
     * @return {@link Integer}
     */
    Integer insertBatchByProperty(List<Payment> list);

    /**
     * 根据对象属性带主键更新
     *
     * @param payment 实例对象
     * @return {@link Integer}
     */
    Integer updateByPrimaryKey(Payment payment);

    /**
    * 根据对象属性带主键列表批量更新
    *
    * @param list 实例对象列表
    * @return {@link Integer}
    */
    Integer updateBatchByPrimaryKey(List<Payment> list);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@link Integer}
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return {@link Integer}
     */
    Integer deleteBatchByPrimaryKey(List<Long> list);

    /**
     * 根据属性删除
     *
     * @param payment 实例对象
     * @return {@link Integer}
     */
    Integer deleteByProperty(Payment payment);

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return {@link Payment}
     */
    Payment selectByPrimaryKey(Long id);

    /**
     * 根据属性进行查询
     *
     * @param payment 实例对象
     * @return {@link List<Payment>}
     */
    List<Payment> selectByProperty(Payment payment);

    /**
     * 根据属性进行查询统计
     *
     * @param payment 实例对象
     * @return {@link Long}
     */
    Long countByProperty(Payment payment);

    int create(Payment payment);

    Payment getPaymentById(Long id);
}

