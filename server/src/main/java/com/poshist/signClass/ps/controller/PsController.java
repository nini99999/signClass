package com.poshist.signClass.ps.controller;

import com.poshist.signClass.common.vo.BaseVO;
import com.poshist.signClass.common.vo.PageVO;
import com.poshist.signClass.ps.service.CustomService;
import com.poshist.signClass.ps.vo.CustomVO;
import com.poshist.signClass.ps.vo.RechargeInfoVO;
import com.poshist.signClass.ps.vo.TagInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ps")
public class PsController {
    @Autowired
    private CustomService customService;

    @RequestMapping("/mobileValid")
    public BaseVO mobileValid(String mobile) {
        BaseVO baseVO = new BaseVO();
        boolean mobileValid = customService.mobileValid(mobile);
        baseVO.setData(mobileValid);
        return baseVO;
    }

    @RequestMapping("/customLogin")
    public BaseVO customLogin(String chatCode) {
        BaseVO baseVO = new BaseVO();
        CustomVO customVO = customService.Login(chatCode);
        if (null == customVO) {
            baseVO.setStatus("0002");
            baseVO.setMsg("客户未注册");
        } else {
            baseVO.setData(baseVO);
        }
        return baseVO;
    }

    @RequestMapping("/getCustomList")
    public BaseVO getCustomList(@RequestBody Map paramMap) {
        BaseVO baseVO = new BaseVO();
        PageVO pageVO = new PageVO(paramMap);
        CustomVO customVO = new CustomVO();
        if (null != paramMap.get("mobile")) {
            customVO.setMobile(paramMap.get("mobile").toString());
        }
        baseVO.setData(customService.getCustomList(pageVO, customVO));
        return baseVO;
    }

    @RequestMapping("/recharge")
    public BaseVO recharge(@RequestBody RechargeInfoVO rechargeInfoVO) {
        BaseVO baseVO = new BaseVO();
        customService.recharge(rechargeInfoVO);
        return baseVO;
    }

    @RequestMapping("/addTag")
    public BaseVO addTag(@RequestBody TagInfoVO tagInfoVO) {
        BaseVO baseVO = new BaseVO();
        customService.addTag(tagInfoVO);
        return baseVO;
    }

    @RequestMapping("/removeTag")
    public BaseVO removeTag(@RequestBody TagInfoVO tagInfoVO) {
        BaseVO baseVO = new BaseVO();
        customService.removeTag(tagInfoVO);
        return baseVO;
    }

    @RequestMapping("/getTagList")
    public BaseVO getTagList(@RequestBody TagInfoVO tagInfoVO) {
        BaseVO baseVO = new BaseVO();
        baseVO.setData(customService.getTagList(tagInfoVO));
        return baseVO;
    }


}
