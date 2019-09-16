package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.ClassArea;

import java.util.ArrayList;
import java.util.List;

public class ClassAreaVO {
    private Long id;
    private String name;
    private String memo;
    private Integer status;
    private List<ClassSeatVO> classSeats = new ArrayList<>();

    public ClassAreaVO() {
    }

    public ClassAreaVO(ClassArea classArea) {
        setName(classArea.getName());
        setMemo(classArea.getMemo());
        setStatus(classArea.getStatus());
        setId(classArea.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addClassSeat(ClassSeatVO classSeatVO) {
        classSeats.add(classSeatVO);
    }

    public List<ClassSeatVO> getClassSeats() {
        return classSeats;
    }

    public void setClassSeats(List<ClassSeatVO> classSeats) {
        this.classSeats = classSeats;
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
