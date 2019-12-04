package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ps_recharge_info")
@EntityListeners(AuditingEntityListener.class)
public class RechargeInfo extends AbstractEntity {
    //0时长 1天卡 2周卡 3月卡 4季卡 5半年卡 6年卡 7金额
    private String type;
    private Double value;
    //0未使用 1使用中 2已使用
    private Integer status;
    private Double usedValue;
    private Date startTime;
    private Date endTime;

    private Date createTime;
    @OneToOne
    @JoinColumn(name = "custom_id",referencedColumnName = "id")
    private Custom custom;
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

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
