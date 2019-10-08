package com.poshist.signClass.ps.service;

import com.poshist.signClass.ps.entity.Custom;
import com.poshist.signClass.ps.respository.CustomDao;
import com.poshist.signClass.ps.vo.CustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomService {
    @Autowired
    private CustomDao customDao;
    public boolean mobileValid(String mobile){
        Custom custom=customDao.getFirstByMobile(mobile);
        if(null==custom){
            return true;
        }
        return  false;
    }

    public CustomVO Login(String chatCode){
        Custom custom=customDao.getFirstByChatCode(chatCode);
        if(null!=custom){
            return new CustomVO (custom);
        }
        return null;
    }
}