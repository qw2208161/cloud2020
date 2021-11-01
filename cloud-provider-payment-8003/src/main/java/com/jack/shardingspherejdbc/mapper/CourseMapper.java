package com.jack.shardingspherejdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @author zhqin.zhou
 * @date 2021/10/8 0:27
 * @description com.jack.shardingspherejdbc.mapper.CourseMapper
 */
@Repository
@MapperScan("com.jack.shardingspherejdbc.mapper")
public interface CourseMapper extends BaseMapper<Course> {

}
