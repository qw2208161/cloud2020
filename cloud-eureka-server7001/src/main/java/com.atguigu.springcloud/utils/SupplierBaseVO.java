package com.atguigu.springcloud.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:29
 * @description SupplierBaseVO
 */
public class SupplierBaseVO implements Serializable {

    private static final long serialVersionUID = -6709321362109045219L;
    //id
    private Long id;

    //供应商ID
    private Long supplierId;

    //供应商编号
    private String supplierNo;


    //供应商签约主体
    private String supplierName;


    //供应商类型
    private Integer supplierTypeId;


    //提供产品名称
    private String productName;


    //供货类型(1、唯一 2、多家)
    private Integer supplyType;


    //是否一般纳税人（1 是 0 否）
    private Integer taxpayerType;


    //供应商类别
    private Integer supplierClassify;

    //l联系人姓名
    private String contactName;

    //联系人电话
    private String contactMobile;

    //认证状态 0 待认证 1 待补全  2 认证通过 3 永久驳回 4 停用 5 审批中 6 认证中
    private Integer authenticationStatus;

    //认证状态描述
    private String authenticationStatusDesc;

    //信息是否完整描述
    private String completeDesc;

    //供货类型描述
    private String supplyTypeDesc;

    //是否一般纳税人描述
    private String taxpayerTypeDesc;

    //供应商类型
    private String subjectTypeName;

    //供应商分类
    private String categoryName;

    //生效时间
    private Date effeTime;

    private String taxpayerNum;

    //创建时间
    private Date createTime;

    //招投标状态 4认证中 3已邀请 2被拒绝 1认证通过
    private Integer tenderingStatus;

    private Long recordId;

    private Long orderId;

    public String getTaxpayerNum() {
        return taxpayerNum;
    }

    public void setTaxpayerNum(String taxpayerNum) {
        this.taxpayerNum = taxpayerNum;
    }

    public String getDataAuthority() {
        return dataAuthority;
    }

    public void setDataAuthority(String dataAuthority) {
        this.dataAuthority = dataAuthority;
    }

    //数据权限（集团，租车、专车，买买车、闪贷）
    private String dataAuthority;

    public Integer getTenderingStatus() {
        return tenderingStatus;
    }

    public void setTenderingStatus(Integer tenderingStatus) {
        this.tenderingStatus = tenderingStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getSupplierTypeId() {
        return supplierTypeId;
    }

    public void setSupplierTypeId(Integer supplierTypeId) {
        this.supplierTypeId = supplierTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(Integer supplyType) {
        this.supplyType = supplyType;
    }

    public Integer getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(Integer taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public Integer getSupplierClassify() {
        return supplierClassify;
    }

    public void setSupplierClassify(Integer supplierClassify) {
        this.supplierClassify = supplierClassify;
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getAuthenticationStatusDesc() {
        return authenticationStatusDesc;
    }

    public void setAuthenticationStatusDesc(String authenticationStatusDesc) {
        this.authenticationStatusDesc = authenticationStatusDesc;
    }

    public String getCompleteDesc() {
        return completeDesc;
    }

    public void setCompleteDesc(String completeDesc) {
        this.completeDesc = completeDesc;
    }

    public String getSupplyTypeDesc() {
        return supplyTypeDesc;
    }

    public void setSupplyTypeDesc(String supplyTypeDesc) {
        this.supplyTypeDesc = supplyTypeDesc;
    }

    public String getTaxpayerTypeDesc() {
        return taxpayerTypeDesc;
    }

    public void setTaxpayerTypeDesc(String taxpayerTypeDesc) {
        this.taxpayerTypeDesc = taxpayerTypeDesc;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getEffeTime() {
        return effeTime;
    }

    public void setEffeTime(Date effeTime) {
        this.effeTime = effeTime;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
