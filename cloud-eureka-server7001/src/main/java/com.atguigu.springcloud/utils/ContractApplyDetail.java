package com.atguigu.springcloud.utils;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:31
 * @description ContractApplyDetail
 */
@Data
public class ContractApplyDetail extends ExcelImportModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键id
    private Long id;


    //物料编号
    private String suppliesId;


    //物料名称
    private String suppliesName;


    //服务物料描述
    private String suppliesDescription;


    //型号
    private String suppliesModel;


    //规格
    private String suppliesFormat;


    //品牌
    private String suppliesBrand;

    //是否入库String
    private String warehouseString = "";

    //数量
    private BigDecimal suppliesNum;


    //单价
    private BigDecimal suppliesUnitPrice;

    //单位
    private String suppliesUnit;

    //单位名称
    private String unitName;

    //币种
    private Integer currencyType;

    //币种名称
    private String currencyName;

    //汇率
    private String currencyExchange;

    //税率
    private Integer taxRate;

    //税率名称
    private String taxRateName;

    //不含税价
    private BigDecimal totalPriceWithoutTax;

    //含税价
    private BigDecimal totalPriceWithTax;


    //原币金额
    private BigDecimal originalCurrencyPrice;


    //本币金额(含税)
    private BigDecimal localCurrencyPrice;


    //税额
    private BigDecimal taxPrice;


    //备注
    private String remark;


    //采购申请单号
    private String detailId;


    //采购计划决议类型
    private Integer businessType;

    //删除标识
    private Integer isDeleted;

    //采购决议编号
    private String detailCode;

    // 来源ID
    private Long sourceId;

    private Integer index;

    //是否入库 0.否 1.是
    private Integer warehouseFlag;


    //物料分类编码
    private String categoryCode;

    //物料分类属性
    private Integer materialPropertiesCode;

    private List<SupplierBaseVO> suppliers;


}
