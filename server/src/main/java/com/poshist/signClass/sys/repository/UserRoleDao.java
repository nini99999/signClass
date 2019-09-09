package com.poshist.signClass.sys.repository;


import com.poshist.signClass.sys.entity.Role;
import com.poshist.signClass.sys.entity.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleDao  extends CrudRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole> {
    public List<UserRole> findByRole(Role role);
}
