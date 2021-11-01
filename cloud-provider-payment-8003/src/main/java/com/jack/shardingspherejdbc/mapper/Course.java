package com.jack.shardingspherejdbc.mapper;

import lombok.Data;

/**
 * @author zhqin.zhou
 * @date 2021/10/8 0:25
 * @description com.jack.shardingspherejdbc.mapper.Course
 */
@Data
public class Course {

    private Long cid;
    private String cname;
    private Long userId;
    private String status;

}