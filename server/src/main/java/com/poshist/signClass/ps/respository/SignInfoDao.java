package com.poshist.signClass.ps.respository;

import com.poshist.signClass.ps.entity.Custom;
import com.poshist.signClass.ps.entity.SignInfo;
import org.springframework.data.repository.CrudRepository;

public interface SignInfoDao  extends CrudRepository<SignInfo, Long> {
    SignInfo getFirstByCustomAndEndTimeIsNull(Custom custom);
}
