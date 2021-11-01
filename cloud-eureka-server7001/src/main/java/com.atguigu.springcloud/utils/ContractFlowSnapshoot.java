package com.atguigu.springcloud.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:30
 * @description ContractFlowSnapshoot
 */
@Data
public class ContractFlowSnapshoot implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;


    //工单id
    private Long billId;


    //流程节点id
    private Integer nodeId;


    //节点类型
    private String nodeType;


    //节点名称
    private String nodeName;


    //部门
    private String department;


    //职位
    private String position;


    //状态
    private Integer status;


    //操作时间
    private Date operateTime;


    //审批人id
    private Integer approverId;


    //审批人名称
    private String approverName;


    //
    private Integer contractFlowDetailsId;


    //节点编号
    private Integer code;


    //工号
    private String employeeNo;


    //流程模型key
    private String flowType;


    //流程实例ID
    private String procInstId;

    // 审批节点任务ID
    private String taskId;

    //流程实例ID
    private String remark;

    //配置表ID
    private Long configId;

    //排序
    private Integer sort;

    /**
     * 自动审批json
     */
    private String autoApproval;

    private List<ContractApplyDetail> applyDetails;
}
