package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import com.poshist.signClass.sys.entity.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ps_flow")
@EntityListeners(AuditingEntityListener.class)
public class SeatLog extends AbstractEntity {
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Integer status;
    @OneToOne
    @JoinColumn(name = "create_user_id",referencedColumnName = "id")
    private User createUser;
    @OneToOne
    @JoinColumn(name = "custom_id",referencedColumnName = "id")
    private Custom custom;
    @OneToOne
    @JoinColumn(name = "seat_id",referencedColumnName = "id")
    private ClassSeat seat;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public ClassSeat getSeat() {
        return seat;
    }

    public void setSeat(ClassSeat seat) {
        this.seat = seat;
    }
}
