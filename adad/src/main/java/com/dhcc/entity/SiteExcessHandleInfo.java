package com.dhcc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SiteExcessHandleInfo)实体类
 *
 * @author makejava
 * @since 2020-07-23 14:32:39
 */
public class SiteExcessHandleInfo implements Serializable {
    private static final long serialVersionUID = 786316148918218847L;
    
    private Long id;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;
    /**
    * 处理状态
    */
    private Integer status;
    /**
    * 处理时间
    */
    private Date collectTime;
    /**
    * 是否属实（1代表属实，-1代表不属实）
    */
    private Integer isTrue;
    /**
    * 处罚类型
    */
    private String punishType;
    /**
    * 处罚内容
    */
    private String punishContent;
    /**
    * 处理照片
    */
    private String handleImage;
    /**
    * 超标原因
    */
    private String excessReason;
    /**
    * 备注
    */
    private String remark;
    /**
    * 处理用户（user表的username）
    */
    private String username;
    /**
    * site_excess_census_infod 表的主键ID
    */
    private Long siteExcessCensusId;
    
    private String backup1;
    
    private String backup2;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
    }

    public String getPunishType() {
        return punishType;
    }

    public void setPunishType(String punishType) {
        this.punishType = punishType;
    }

    public String getPunishContent() {
        return punishContent;
    }

    public void setPunishContent(String punishContent) {
        this.punishContent = punishContent;
    }

    public String getHandleImage() {
        return handleImage;
    }

    public void setHandleImage(String handleImage) {
        this.handleImage = handleImage;
    }

    public String getExcessReason() {
        return excessReason;
    }

    public void setExcessReason(String excessReason) {
        this.excessReason = excessReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSiteExcessCensusId() {
        return siteExcessCensusId;
    }

    public void setSiteExcessCensusId(Long siteExcessCensusId) {
        this.siteExcessCensusId = siteExcessCensusId;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

}