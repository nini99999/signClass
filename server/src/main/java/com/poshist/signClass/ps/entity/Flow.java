package com.poshist.signClass.ps.entity;

import com.poshist.signClass.common.entity.AbstractEntity;
import com.poshist.signClass.sys.entity.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_ps_flow")
@EntityListeners(AuditingEntityListener.class)
public class Flow extends AbstractEntity {
    private  Double beforeBalance;
    private Double beforeFrozen;
    private Double change;
    private Double afterBalance;
    private Double afterFrozen;
    private Date createTime;
    private User createUser;
}
