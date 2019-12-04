package com.poshist.signClass.ps.respository;

import com.poshist.signClass.ps.entity.Custom;
import com.poshist.signClass.ps.entity.TagInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagInfoDao extends CrudRepository<TagInfo, Long> {
    public List<TagInfo> findByCustomAndType(Custom custom, String type);
}
