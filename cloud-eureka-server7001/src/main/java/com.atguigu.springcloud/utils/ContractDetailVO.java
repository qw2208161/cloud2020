package com.atguigu.springcloud.utils;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:28
 * @description ContractDetailVO
 */
@Data
public class ContractDetailVO {

    /**
     * 项目编码
     */
    private String projectCode;

    private Boolean bWNewRetail;

    private ContractBase base;

    private ContractInfo info;

    private ContractPay pay;

    private ContractOther other;

    private ContractFile file;

    private List<ContractInformation> information;

    //private List<SupplierBaseVO> suppliers;

    private List<ContractFlowSnapshoot> snapshoots;

    //private List<ContractApplyDetail> applyDetails;

    /**
     * 采购决议申请的立项单号集合，用户控制合同创建/修改时立项选择的控制
     */
    private String[] applicationList;

    /**
     * 费用分摊部门信息
     */
    private FeeBearVO feeBearVO;

    /**
     * 费用分摊金额信息列表
     */
    private List<FeeBearPrice> feeBearPrices;

    /**
     * 基本信息
     */
    @Data
    public static class ContractBase {

        /**
         * 合同ID
         */
        private Long id;

        /**
         * 合同编号
         */
        private String code;

        /**
         * 历史合同总额
         */
        private Double historyContractAmount;

        private String name;

        private Integer status;

        private String purchaseNo;

        private Integer purchaseId;

        private String purchaseCode;

        private Integer purchaseStatus;

        private String purchaseTypeName;

        private String purchaseTypeCode;

        /**
         * 采购项目ID
         */
        private Long purchaseTypeId;

        /**
         * 计划总金额
         */
        private BigDecimal totalPrice;

        private String matters;

        private Integer addedType;

        private String addedContractName;

        private Integer renewType;

        private String renewContractName;

        private String renewContract;

        private Integer frameworkType;

        private String frameworkContractName;

        private Integer normalType;

        private String contractAdministratorName;

        private int contractAdministratorId;

        private Integer otherType;

        private String otherContractName;

        private String financialRemarks;

        private Integer type;

        private String addedContract;

        private String frameworkContract;

        private String otherContract;

        private String contractTypeId;

        private String submitType;

        /**
         * 合同盖章人姓名
         */
        private String sealEmpName;

        /**
         * 合同盖章人编号
         */
        private String sealEmpNo;

        /**
         * 合同盖章人所属部门
         */
        private String sealEmpDeptName;

        /**
         * 采购申请主键ID,多个以\",\"分割
         */
        private String applicationIds;

        /**
         * 来源类型(1:框架决议;2:普通决议;3:招标决议;4:框架招标决议)
         */
        private String originType;

        /**
         * 是否为新业务
         */
        private Boolean isPurchaseNewBusiness;

        /**
         * 上线前补录(0:否;1:是)
         */
        private Integer onlineMend;

    }

    /**
     * 合同信息
     */
    @Data
    public static class ContractInfo {

        private String otherContractSubjectName;

        private String otherContractSubjectIds;

        private String ourContractSubjectName;

        private Integer ourContractSubjectId;

        private String preEffectiveDate;

        private Integer endDateType;

        private String endDate;

        private String contractEffectiveDate;

        private String contractSignatoryName;

        private Integer contractSignatoryId;

        private String departmentName;

        private String departmentId;

        private String plateName;

        private Integer plateId;

        private String cityName;

        private String constractTermsRemarks;

        /**
         * 我司签约主体code
         */
        private String signingSubjectCode;

        /**
         * 我司签约主体name
         */
        private String signingSubjectName;

        /**
         * 配件项目
         */
        private Boolean fittingsProject;
    }

    /**
     * 付款信息
     */
    @Data
    public static class ContractPay {

        private BigDecimal taxUnitPrice;

        private BigDecimal untaxUnitPrice;

        private Integer num;

        private BigDecimal taxAllPrice;

        private String sumPayPrice;

        private String unPayPrice;

        private Integer invoiceType;

        private Integer invoiceTime;

        private BigDecimal foregift;

        private String foregiftDate;

        private String freeStartDate;

        private String freeEndDate;

        private Integer installPayType;

        private Integer warrantyMoneyType;

        private BigDecimal preLastPrice;

        private Double taxRate;

        private String payee;

        private String bankIds;

        private BigDecimal beforePayPrice;

        private BigDecimal leaseTotalMoney;

        private BigDecimal propertyTotalMoney;

        private String amountRemarks;

        /**
         * 是否办公场地、物业租赁项目
         */
        private Boolean officeProject;

        private BigDecimal currencyPrice;

        private String currencyType;

        private String payCycle;

        private String payType;
    }

    /**
     * 其他信息
     */
    @Data
    public static class ContractOther {

        private String createUser;

        private String createUserId;

        private String createTime;

        private String updateTime;

        private String companyPlane;

        private String mobile;

        private String remarks;

        private String updateUser;

        private String updateUserId;

        private String deparment;

        private String email;

        /**
         * 退回草稿说明
         */
        private String backRemarks;
    }


    /**
     * 付款分期信息
     */
    @Data
    public static class ContractInformation {

        private Integer id;

        private Integer term;

        private BigDecimal money;

        private Double pricePrezent;

        private String prePayTime;

        private Integer days;

        private String contractCode;
    }

    /**
     * 附件信息
     */
    @Data
    public static class ContractFile {

        /**
         * 合同附件
         */
        private String appendicesUrl;

        /**
         * 比价单附件
         */
        private String pricelistUrl;

        /**
         * 盖章合同附件
         */
        private String sealUrl;
    }

}
