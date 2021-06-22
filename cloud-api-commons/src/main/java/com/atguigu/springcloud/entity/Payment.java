package com.atguigu.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 实体
 *
 * @author zzq
 * @version 1.0.0
 * @date 2021/06/21 16:11:03
 * @copyright All Rights Reserved.
 */
@Data
public class Payment implements Serializable {
    private static final long serialVersionUID = -19565901508638199L;

    private Long id;

    private String serial;

}
