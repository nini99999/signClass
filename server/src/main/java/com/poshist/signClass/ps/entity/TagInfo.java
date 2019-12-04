package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import com.poshist.signClass.sys.entity.Dictionary;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ps_tag_info")
@EntityListeners(AuditingEntityListener.class)
public class TagInfo extends AbstractEntity {
    private Date createTime;
    private String type;
    @OneToOne
    @JoinColumn(name = "tag_id",referencedColumnName = "id")
    private Dictionary tag;
    @OneToOne
    @JoinColumn(name = "custom_id",referencedColumnName = "id")
    private Custom custom;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Dictionary getTag() {
        return tag;
    }

    public void setTag(Dictionary tag) {
        this.tag = tag;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }
}
