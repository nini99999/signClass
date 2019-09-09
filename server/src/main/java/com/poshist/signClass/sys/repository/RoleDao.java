package com.poshist.signClass.sys.repository;


import com.poshist.signClass.sys.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleDao extends CrudRepository<Role, Long> {
     List<Role> getAllByStatus(String status);
}
