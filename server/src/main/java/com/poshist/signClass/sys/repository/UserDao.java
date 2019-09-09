package com.poshist.signClass.sys.repository;


import com.poshist.signClass.sys.entity.Department;
import com.poshist.signClass.sys.entity.User;
import com.poshist.signClass.sys.entity.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findUserByUserNameAndStatus(String userName,Integer status);
    User findFirstByDepartmentAndUserRolesIn(Department department, List<UserRole> userRoles);
    List<User> findAllByUserRolesIn(List<UserRole> userRoles);
   }
