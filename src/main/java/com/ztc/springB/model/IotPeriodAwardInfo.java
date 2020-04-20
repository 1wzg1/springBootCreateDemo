package com.ztc.springB.model;

import java.io.Serializable;
import java.util.Date;

/**
 * (IotPeriodAwardInfo)实体类
 *
 * @author makejava
 * @since 2020-04-11 16:41:23
 */
public class IotPeriodAwardInfo implements Serializable {
    private static final long serialVersionUID = 487254633964687429L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 分类id
    */
    private Integer cid;
    /**
    * 奖品名称
    */
    private String awardName;
    /**
    * 奖品类型
    */
    private String awardType;
    /**
    * 活动类型：1-步步为王个人赛
    */
    private String activityType;
    /**
    * 奖品面值
    */
    private String faceValue;
    /**
    * 奖品状态：0-未使用，1-已使用
    */
    private String status;
    /**
    * 卡号
    */
    private String awardNo;
    /**
    * 卡密
    */
    private String awardWord;
    /**
    * 奖品码：JDK100-京东卡100元;JDK50-京东卡50元;JDK20-京东卡20元
    */
    private String awardCode;
    /**
    * 京东卡有效开始时间
    */
    private Date cardStartTime;
    /**
    * 京东卡有效结束时间
    */
    private Date cardEndTime;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date modifyTime;
    /**
    * 创建人
    */
    private String createBy;
    /**
    * 修改人
    */
    private String modifyBy;
    /**
    * 机构id
    */
    private String orgId;
    /**
    * 是否有效：0-无效，1-有效
    */
    private Integer dr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAwardNo() {
        return awardNo;
    }

    public void setAwardNo(String awardNo) {
        this.awardNo = awardNo;
    }

    public String getAwardWord() {
        return awardWord;
    }

    public void setAwardWord(String awardWord) {
        this.awardWord = awardWord;
    }

    public String getAwardCode() {
        return awardCode;
    }

    public void setAwardCode(String awardCode) {
        this.awardCode = awardCode;
    }

    public Date getCardStartTime() {
        return cardStartTime;
    }

    public void setCardStartTime(Date cardStartTime) {
        this.cardStartTime = cardStartTime;
    }

    public Date getCardEndTime() {
        return cardEndTime;
    }

    public void setCardEndTime(Date cardEndTime) {
        this.cardEndTime = cardEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

}