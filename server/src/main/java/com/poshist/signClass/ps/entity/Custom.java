package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import com.poshist.signClass.sys.entity.Dictionary;
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
    private String level;
    private Integer signCount;
    //推荐人
    @OneToOne
    @JoinColumn(name = "recommended_id",referencedColumnName = "id")
    private Custom recommended;
    @OneToOne
    @JoinColumn(name = "source_id",referencedColumnName = "id")
    private Dictionary source;
    private Integer status;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Dictionary getSource() {
        return source;
    }

    public void setSource(Dictionary source) {
        this.source = source;
    }

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
