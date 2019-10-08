package com.poshist.signClass.ps.controller;

import com.poshist.signClass.common.vo.BaseVO;
import com.poshist.signClass.ps.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ps")
public class PsController {
    @Autowired
    private CustomService customService;
    @RequestMapping("/mobileValid")
    public BaseVO mobileValid(String mobile){
        BaseVO baseVO=new BaseVO();
        if(!customService.mobileValid(mobile)){
            baseVO.setStatus("0001");
            baseVO.setMsg("手机号以存在");
        }
        return baseVO;
    }


}
