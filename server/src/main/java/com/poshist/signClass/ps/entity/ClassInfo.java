package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import com.poshist.signClass.sys.entity.Department;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_ps_class")
@EntityListeners(AuditingEntityListener.class)
public class ClassInfo extends AbstractEntity {
    private String name;
    private String memo;
    private Integer status;
    private String address;
    @OneToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private List<ClassArea> classAreas;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<ClassArea> getClassAreas() {
        return classAreas;
    }

    public void setClassAreas(List<ClassArea> classAreas) {
        this.classAreas = classAreas;
    }
}
