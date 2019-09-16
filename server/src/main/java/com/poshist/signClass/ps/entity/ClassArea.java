package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_ps_class_area")
@EntityListeners(AuditingEntityListener.class)
public class ClassArea  extends AbstractEntity {
    private String name;
    private String memo;
    private Integer status;
    @OneToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private ClassInfo classInfo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id",referencedColumnName = "id")
    private List<ClassSeat> classSeats;
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

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public List<ClassSeat> getClassSeats() {
        return classSeats;
    }

    public void setClassSeats(List<ClassSeat> classSeats) {
        this.classSeats = classSeats;
    }
}
