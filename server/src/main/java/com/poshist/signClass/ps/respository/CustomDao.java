package com.poshist.signClass.ps.respository;

import com.poshist.signClass.ps.entity.Custom;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CustomDao extends CrudRepository<Custom, Long> , JpaSpecificationExecutor<Custom> {
    public Custom getFirstByMobile(String mobile);
    public Custom getFirstByChatCode(String chatCode);
}
