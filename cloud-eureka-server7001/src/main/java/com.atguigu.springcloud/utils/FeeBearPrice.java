package com.atguigu.springcloud.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:33
 * @description FeeBearPrice
 */
@Data
public class FeeBearPrice {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 创建人工号
     */
    private Long createEmp;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    /**
     * 修改人工号
     */
    private Long modifyEmp;
    /**
     * 状态（0无效；1有效）
     */
    private Byte status;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 部门编码
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 分摊金额，精确到小数点后两位
     */
    private BigDecimal bearPrice;

    /**
     * 责任中心编码
     */
    private String responsibilityCenterCode;
}

