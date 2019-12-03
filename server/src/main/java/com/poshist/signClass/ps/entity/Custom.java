package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ps_custom")
@EntityListeners(AuditingEntityListener.class)
public class Custom  extends AbstractEntity {
    private String name;
    private String mobile;
    private String chatCode;
    private Double balance;
    private Double frozen;
    private Date regTime;
    //推荐人
    @OneToOne
    @JoinColumn(name = "recommended_id",referencedColumnName = "id")
    private Custom recommended;
    private Integer status;

    public Custom getRecommended() {
        return recommended;
    }

    public void setRecommended(Custom recommended) {
        this.recommended = recommended;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getChatCode() {
        return chatCode;
    }

    public void setChatCode(String chatCode) {
        this.chatCode = chatCode;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getFrozen() {
        return frozen;
    }

    public void setFrozen(Double frozen) {
        this.frozen = frozen;
    }

}
