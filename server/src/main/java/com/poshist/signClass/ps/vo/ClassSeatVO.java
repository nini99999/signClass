package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.ClassSeat;

public class ClassSeatVO {
    private Long id;
    private String name;
    private String memo;
    private Integer status;
    private ClassAreaVO classArea;

    public ClassSeatVO() {
    }

    public ClassSeatVO(ClassSeat classSeat) {
        setName(classSeat.getName());
        setMemo(classSeat.getMemo());
        setStatus(classSeat.getStatus());
        setId(classSeat.getId());
        setClassArea(new ClassAreaVO(classSeat.getClassArea()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassAreaVO getClassArea() {
        return classArea;
    }

    public void setClassArea(ClassAreaVO classArea) {
        this.classArea = classArea;
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
}
