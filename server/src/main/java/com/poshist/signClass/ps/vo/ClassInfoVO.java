package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

public class ClassInfoVO {
    private String name;
    private String memo;
    private Integer status;
    private String address;
    private Long id;
    private Long departmentId;
    private String departmentName;
    private List<ClassAreaVO> classAreas =new ArrayList<>();
    public ClassInfoVO(){}
    public ClassInfoVO(ClassInfo classInfo){
    setName(classInfo.getName());
    setMemo(classInfo.getMemo());
    setStatus(classInfo.getStatus());
    setAddress(classInfo.getAddress());
    setId(classInfo.getId());
    setDepartmentId(classInfo.getDepartment().getId());
    setDepartmentName(classInfo.getDepartment().getName());
    };
    public void addClassArea(ClassAreaVO classAreaVO){
        classAreas.add(classAreaVO);
    }
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<ClassAreaVO> getClassAreas() {
        return classAreas;
    }

    public void setClassAreas(List<ClassAreaVO> classAreas) {
        this.classAreas = classAreas;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
