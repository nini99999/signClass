package com.poshist.signClass.ps.vo;

import com.poshist.signClass.ps.entity.TagInfo;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class TagInfoVO {
    private Date createTime;
    private String type;
    private Long id;
    private String value;
    private Long tagId[];
    private Long customId;
    public TagInfoVO() {
    }

    public TagInfoVO(TagInfo tagInfo) {
        BeanUtils.copyProperties(tagInfo, this);
        setValue(tagInfo.getTag().getName());
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public Long[] getTagId() {
        return tagId;
    }

    public void setTagId(Long[] tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
