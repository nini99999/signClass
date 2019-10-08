package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.Custom;

import java.util.Date;

public class CustomVO {
    private Long id;
    private String name;
    private String mobile;
    private String chatCode;
    private Double balance;
    private Double frozen;
    private Date regTime;
    private Integer status;
    public CustomVO(){}
    public CustomVO(Custom custom){
        setName(custom.getName());
        setMobile(custom.getMobile());
        setChatCode(custom.getChatCode());
        setBalance(custom.getBalance());
        setFrozen(custom.getFrozen());
        setRegTime(custom.getRegTime());
        setStatus(custom.getStatus());
        setId(custom.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
