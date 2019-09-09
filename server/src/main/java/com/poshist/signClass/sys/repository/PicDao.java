package com.poshist.signClass.sys.repository;


import com.poshist.signClass.sys.entity.Pic;
import org.springframework.data.repository.CrudRepository;

public interface PicDao extends CrudRepository<Pic, Long> {
   Pic findFirstByTypeAndObjectId(String type,Long objectId);
}
