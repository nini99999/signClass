package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.RechargeInfo;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class RechargeInfoVO {
    //0时长 1天卡 2周卡 3月卡 4季卡 5半年卡 6年卡 7金额
    private String type;
    private Double value;
    //0未使用 1使用中 2已使用
    private Integer status;
    private Double usedValue;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Long customId;

    public RechargeInfoVO() {
    }

    public RechargeInfoVO(RechargeInfo rechargeInfo) {
        BeanUtils.copyProperties(rechargeInfo, this);

    }

    public RechargeInfo toDTO(RechargeInfo rechargeInfo) {
        BeanUtils.copyProperties(this, rechargeInfo);
        return rechargeInfo;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getUsedValue() {
        return usedValue;
    }

    public void setUsedValue(Double usedValue) {
        this.usedValue = usedValue;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
