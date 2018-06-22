package com.ht.lottery.service;

import com.ht.lottery.entity.User;
import com.ht.lottery.result.AjaxResult;

/**
 * @author king
 */
public interface UserService {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(User user);

    User selectByPrimaryKey(Integer id);

    Integer update(User user);

    /**
     * 用户登录
     *
     * @param mobile:手机号
     * @param usercode:手机唯一标示
     * @param shareCode:分享链接手机号
     * @return
     */
    AjaxResult login(String mobile, String usercode, String shareCode, String username);

    /**
     * 查询用户是否存在
     *
     * @param usercode:手机号
     * @return
     */
    User selectByUsercode(String usercode);

    /**
     * 用户抽奖次数<= 0的用户统一设置抽奖次数为1
     *
     * @return
     */
    Integer batchDealZeroUserNum();

    /**
     * 点击链接
     *
     * @param usercode:手机唯一标示
     * @param shareCode:分享标示
     * @return
     */
    AjaxResult clickLink(String usercode, String shareCode);
}