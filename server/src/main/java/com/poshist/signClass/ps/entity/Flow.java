package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import com.poshist.signClass.sys.entity.Dictionary;
import com.poshist.signClass.sys.entity.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ps_flow")
@EntityListeners(AuditingEntityListener.class)
public class Flow extends AbstractEntity {
    private  Double beforeBalance;
    private Double beforeFrozen;
    private Double change;
    private Double afterBalance;
    private Double afterFrozen;
    private Date createTime;
    @OneToOne
    @JoinColumn(name = "create_user_id",referencedColumnName = "id")
    private User createUser;
    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private Dictionary item;

    public Dictionary getItem() {
        return item;
    }

    public void setItem(Dictionary item) {
        this.item = item;
    }

    public Double getBeforeBalance() {
        return beforeBalance;
    }

    public void setBeforeBalance(Double beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public Double getBeforeFrozen() {
        return beforeFrozen;
    }

    public void setBeforeFrozen(Double beforeFrozen) {
        this.beforeFrozen = beforeFrozen;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Double afterBalance) {
        this.afterBalance = afterBalance;
    }

    public Double getAfterFrozen() {
        return afterFrozen;
    }

    public void setAfterFrozen(Double afterFrozen) {
        this.afterFrozen = afterFrozen;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }
}
