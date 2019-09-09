package com.poshist.signClass.sys.repository;


import com.poshist.signClass.sys.entity.Dictionary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DictionaryDao extends CrudRepository<Dictionary, Long> {
    public List<Dictionary> getAllByStatusAndTypeOrderById(Integer status, String type);
}
