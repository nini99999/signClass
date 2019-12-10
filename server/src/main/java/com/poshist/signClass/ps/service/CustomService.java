package com.poshist.signClass.ps.service;

import com.poshist.signClass.common.RunTimeException;
import com.poshist.signClass.common.utils.CommonUtils;
import com.poshist.signClass.common.vo.PageVO;
import com.poshist.signClass.ps.entity.Custom;
import com.poshist.signClass.ps.entity.RechargeInfo;
import com.poshist.signClass.ps.entity.SignInfo;
import com.poshist.signClass.ps.entity.TagInfo;
import com.poshist.signClass.ps.respository.CustomDao;
import com.poshist.signClass.ps.respository.RechargeInfoDao;
import com.poshist.signClass.ps.respository.SignInfoDao;
import com.poshist.signClass.ps.respository.TagInfoDao;
import com.poshist.signClass.ps.vo.CustomVO;
import com.poshist.signClass.ps.vo.RechargeInfoVO;
import com.poshist.signClass.ps.vo.TagInfoVO;
import com.poshist.signClass.sys.entity.Dictionary;
import com.poshist.signClass.sys.repository.DictionaryDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CustomService {
    @Autowired
    private CustomDao customDao;
    @Autowired
    private RechargeInfoDao rechargeInfoDao;
    @Autowired
    private TagInfoDao tagInfoDao;
    @Autowired
    private DictionaryDao dictionaryDao;
    @Autowired
    private SignInfoDao signInfoDao;
    @Value(("${ps.price}"))
    private Double price;

    @Scheduled(cron = "0 0 * * * ?")
    private void changeRechargeStatus() {
        List<RechargeInfo> rechargeInfos = rechargeInfoDao.findByStatusAndType(1, "3");
        Long now = new Date().getTime();
        for (RechargeInfo rechargeInfo : rechargeInfos) {
            if (rechargeInfo.getEndTime().getTime() <= now) {
                rechargeInfo.setStatus(2);
                rechargeInfoDao.save(rechargeInfo);
            }
        }
    }

    public boolean mobileValid(String mobile) {
        Custom custom = customDao.getFirstByMobile(mobile);
        if (null == custom) {
            return false;
        }
        return true;
    }

    public CustomVO Login(String chatCode) {
        Custom custom = customDao.getFirstByChatCode(chatCode);
        if (null != custom) {
            return new CustomVO(custom);
        }
        return null;
    }

    public PageVO getCustomList(PageVO pageVO, CustomVO customVO) {
        Pageable pageable = PageRequest.of(pageVO.getPageCount() - 1, pageVO.getPageSize());
        Page page = customDao.findAll(new Specification<Custom>() {
            @Override
            public Predicate toPredicate(Root<Custom> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNoneEmpty(customVO.getMobile())) {
                    list.add(cb.like(root.get("mobile"), "%" + customVO.getMobile() + "%"));
                }

                return CommonUtils.getPredicate(root, query, cb, list, "id");
            }
        }, pageable);
        Iterator it = page.iterator();
        while (it.hasNext()) {
            Custom custom = (Custom) it.next();
            pageVO.addData(new CustomVO(custom));
        }
        pageVO.setDataCount(page.getTotalElements());
        return pageVO;
    }

    public void recharge(RechargeInfoVO rechargeInfoVO) {
        RechargeInfo rechargeInfo = new RechargeInfo();
        rechargeInfo = rechargeInfoVO.toDTO(rechargeInfo);
        Custom custom = customDao.findById(rechargeInfoVO.getCustomId()).get();
        rechargeInfo.setCustom(custom);
        rechargeInfo.setStatus(0);
        rechargeInfo.setCreateTime(new Date());
        rechargeInfoDao.save(rechargeInfo);
    }

    public void addTag(TagInfoVO tagInfoVO) {
        Custom custom = customDao.findById(tagInfoVO.getCustomId()).get();
        Date now = new Date();
        for (Long tagId : tagInfoVO.getTagId()) {
            TagInfo tagInfo = new TagInfo();
            Dictionary tag = dictionaryDao.findById(tagId).get();
            tagInfo.setCustom(custom);
            tagInfo.setTag(tag);
            tagInfo.setType(tag.getType());
            tagInfo.setCreateTime(now);
            tagInfoDao.save(tagInfo);
        }
    }

    public void removeTag(TagInfoVO tagInfoVO) {
        for (Long tagId : tagInfoVO.getTagId()) {
            tagInfoDao.deleteById(tagId);
        }
    }

    public List<TagInfoVO> getTagList(TagInfoVO tagInfoVO) {
        Custom custom = customDao.findById(tagInfoVO.getCustomId()).get();
        List<TagInfo> tagInfos = tagInfoDao.findByCustomAndType(custom, tagInfoVO.getType());
        List<TagInfoVO> tagInfoVOS = new ArrayList<>();
        for (TagInfo tagInfo : tagInfos) {
            tagInfoVOS.add(new TagInfoVO(tagInfo));
        }
        return tagInfoVOS;
    }

    public String sign(CustomVO customVO) throws RunTimeException {
        Custom custom = customDao.getFirstByMobile(customVO.getMobile());
        if (null == custom) {
            throw new RunTimeException("1001", "用户没有注册");
        }
        List<RechargeInfo> rechargeInfos = getValidRecharge(custom);
        if (rechargeInfos.isEmpty()) {
            throw new RunTimeException("1002", "用户没有有效余额");
        }
        SignInfo signInfo = signInfoDao.getFirstByCustomAndEndTimeIsNull(custom);
        Date now = new Date();
        //第一次签到
        if (null == signInfo) {
            signInfo = new SignInfo();
            signInfo.setCustom(custom);
            signInfo.setStartTime(now);
        } else {
            signInfo.setEndTime(now);
            signInfo.setConsumeTime(Long.valueOf(now.getTime() - signInfo.getStartTime().getTime() / 1000));
            double time = signInfo.getConsumeTime() - (signInfo.getConsumeTime() % 1800);
            time = time / 3600;
            boolean enough = false;
            for (RechargeInfo rechargeInfo : rechargeInfos) {
                rechargeInfo.setStatus(1);
                if ("1".equals(rechargeInfo.getType())) {
                    if (rechargeInfo.getValue() - rechargeInfo.getUsedValue() - time >= 0) {
                        rechargeInfo.setUsedValue(rechargeInfo.getUsedValue() + time);
                        if (rechargeInfo.getValue() == rechargeInfo.getUsedValue()) {
                            rechargeInfo.setStatus(2);
                        }
                        enough = true;
                        rechargeInfoDao.save(rechargeInfo);
                        break;
                    }
                } else if ("2".equals(rechargeInfo.getType())) {
                    double amt = time * price;
                    if (rechargeInfo.getValue() - rechargeInfo.getUsedValue() - amt >= 0) {
                        rechargeInfo.setUsedValue(rechargeInfo.getUsedValue() + amt);
                        if (rechargeInfo.getValue() == rechargeInfo.getUsedValue()) {
                            rechargeInfo.setStatus(2);
                        }
                        enough = true;
                        rechargeInfoDao.save(rechargeInfo);
                        break;
                    }
                } else {
                    if (rechargeInfo.getStartTime() == null) {
                        rechargeInfo.setStartTime(signInfo.getStartTime());
                        Date endTime = DateUtils.addDays(signInfo.getStartTime(), Integer.valueOf(rechargeInfo.getValue().toString()));
                        rechargeInfo.setEndTime(endTime);
                    }
                    if (rechargeInfo.getEndTime().getTime() >= signInfo.getEndTime().getTime()) {
                        enough = true;
                        break;
                    }

                }
            }
            if (!enough) {
                throw new RunTimeException("1003", "余额不足");
            }

        }
        return "0000";
    }

    public List<RechargeInfo> getValidRecharge(Custom custom) {
        Integer[] status = {0, 1};
        List<RechargeInfo> rechargeInfos = rechargeInfoDao.findByStatusInAndCustomOrderById(status, custom);
        return rechargeInfos;
    }
}
