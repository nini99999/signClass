package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.Custom;
import org.springframework.beans.BeanUtils;

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
    private String recommendedMobile;
    private String level;
    private Integer signCount;
    private String sourceName;
    private Long getSourceId;

    public CustomVO() {
    }

    public CustomVO(Custom custom) {
        BeanUtils.copyProperties(custom, this);
        if (null != custom.getRecommended()) {
            setRecommendedMobile(custom.getRecommended().getMobile());
        }
        if (null != custom.getSource()) {
            setSourceName(custom.getSource().getName());
            setGetSourceId(custom.getSource().getId());
        }
    }

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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Long getGetSourceId() {
        return getSourceId;
    }

    public void setGetSourceId(Long getSourceId) {
        this.getSourceId = getSourceId;
    }

    public String getRecommendedMobile() {
        return recommendedMobile;
    }

    public void setRecommendedMobile(String recommendedMobile) {
        this.recommendedMobile = recommendedMobile;
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
