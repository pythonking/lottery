package com.ht.lottery.service.impl;

import com.ht.lottery.constant.TicketConstans;
import com.ht.lottery.entity.Share;
import com.ht.lottery.entity.User;
import com.ht.lottery.exception.ServiceException;
import com.ht.lottery.mapper.UserMapper;
import com.ht.lottery.result.AjaxResult;
import com.ht.lottery.service.ShareService;
import com.ht.lottery.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShareService shareService;

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        try {
            return userMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            LOGGER.error("方法 deleteByPrimaryKey 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Integer insert(User user) {
        try {
            return userMapper.insert(user);
        } catch (Exception e) {
            LOGGER.error("方法 insert 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer update(User user) {
        try {
            return userMapper.update(user);
        } catch (Exception e) {
            LOGGER.error("方法 insert 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    @Transactional
    public AjaxResult login(String mobile, String usercode, String shareCode, String username) {
        //查询用户是否存在
        User user = this.selectByUsercode(usercode);
        User shareUser = null;
        if (StringUtils.isNotBlank(shareCode)) {
            //查询分享用户是否存在
            shareUser = this.selectByUsercode(shareCode);
            if (null == shareUser) {
                return AjaxResult.error(AjaxResult.STATE_PARAM_ERROR, TicketConstans.PARAM_SHARE_USER_MSG);
            }
        }
        Date nowDate = new Date();
        if (null == user) {
            //没有查询到用户信息:1.新增用户 2.新增用户分享信息
            user = new User(mobile, usercode, username, TicketConstans.TIME_INIT, nowDate);
            Integer count = this.insert(user);
            if (count > 0 && StringUtils.isNotBlank(shareCode)) {
                shareService.insert(new Share(usercode, shareCode, nowDate));
                //分享用户抽奖次数次数加1
                shareUser.setNum(shareUser.getNum() + 1);
                this.update(shareUser);
            }
        } else {
            if (null == shareUser) {
                return AjaxResult.successWithData(user);
            }
            return this.addShare(usercode, shareCode);
        }
        return AjaxResult.successWithData(user);
    }

    @Override
    public User selectByUsercode(String usercode) {
        return userMapper.selectByUsercode(usercode);
    }

    @Override
    public Integer batchDealZeroUserNum() {
        Integer count = null;
        try {
            count = userMapper.batchDealZeroUserNum();
        } catch (Exception e) {
            LOGGER.error("方法 batchDealZeroUserNum 异常,{}", e);
        }
        return count;
    }

    @Override
    public AjaxResult clickLink(String usercode, String shareCode) {
        return this.addShare(usercode, shareCode);
    }

    private AjaxResult addShare(String usercode, String shareCode) {
        User shareUser = this.selectByUsercode(shareCode);
        User user = this.selectByUsercode(usercode);
        Date nowDate = new Date();
        //查询两人以前是否分享过:1如果分享过返回错误信息2.没有分享过则新增分享-->分享用户抽奖次数加1
        List<Share> shareList = shareService.listShare(new Share(usercode, shareCode));
        if (CollectionUtils.isEmpty(shareList)) {
            //新增分享
            shareService.insert(new Share(usercode, shareCode, nowDate));
            //分享用户抽奖次数次数加1
            shareUser.setNum(shareUser.getNum() + 1);
            this.update(shareUser);
            if (null == user) {
                return AjaxResult.successWithData(new User(usercode));
            } else {
                return AjaxResult.successWithData(user);
            }
        } else {
            return AjaxResult.error(TicketConstans.SHARE_ERROR_MSG);
        }
    }
}
