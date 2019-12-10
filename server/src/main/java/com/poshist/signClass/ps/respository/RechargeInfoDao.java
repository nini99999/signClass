package com.poshist.signClass.ps.respository;

import com.poshist.signClass.ps.entity.Custom;
import com.poshist.signClass.ps.entity.RechargeInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RechargeInfoDao   extends CrudRepository<RechargeInfo, Long> {
    List<RechargeInfo> findByStatusInAndCustomOrderById(Integer[] status, Custom custom);
    List<RechargeInfo> findByStatusAndType(Integer status,String type);
}
