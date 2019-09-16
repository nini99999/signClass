package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "t_ps_class_seat")
@EntityListeners(AuditingEntityListener.class)
public class ClassSeat  extends AbstractEntity {
    private String name;
    private String memo;
    private Integer status;
    @OneToOne
    @JoinColumn(name = "area_id",referencedColumnName = "id")
    private ClassArea classArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ClassArea getClassArea() {
        return classArea;
    }

    public void setClassArea(ClassArea classArea) {
        this.classArea = classArea;
    }
}
