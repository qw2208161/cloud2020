package com.atguigu.springcloud.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:32
 * @description FeeBear
 */
@Data
public class FeeBear implements Serializable {

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
     * 项目编号类型：1采购立项；2采购决议；3采购合同
     */
    private Integer codeType;
    /**
     * 项目编号
     */
    private String code;
    /**
     * 费用分摊部门json串：dpName（部门名称）；dpCode（部门编号）；rsCode（责任中心编码）
     */
    private String feeBearDept;
}

