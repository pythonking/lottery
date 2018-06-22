package com.ht.lottery.controller.api;

import com.ht.lottery.constant.TicketConstans;
import com.ht.lottery.entity.User;
import com.ht.lottery.result.AjaxResult;
import com.ht.lottery.service.ControlButtonService;
import com.ht.lottery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ControlButtonService controlButtonService;

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public AjaxResult login(@RequestParam String mobile, @RequestParam String usercode, String shareCode, String userName) {
        if (usercode.equals(shareCode)) {
            return AjaxResult.error(AjaxResult.STATE_PARAM_ERROR, TicketConstans.PARAM_ERROR_MSG);
        }
        AjaxResult ajaxResult = userService.login(mobile, usercode, shareCode, userName);
        return ajaxResult;
    }

    /**
     * 点击链接
     *
     * @param usercode:手机唯一标示
     * @param shareCode:分享标示
     * @return
     */
    @RequestMapping("/link/click")
    public AjaxResult clickLink(@RequestParam String usercode, @RequestParam String shareCode) {
        if (usercode.equals(shareCode)) {
            return AjaxResult.error(AjaxResult.STATE_PARAM_ERROR, TicketConstans.PARAM_ERROR_MSG);
        }
        Integer status = controlButtonService.getStatus();
        if (TicketConstans.STATE_USE.equals(status)) {
            User user = userService.selectByUsercode(usercode);
            if (null == user) {
                return AjaxResult.error(TicketConstans.SHARE_NO_LOGIN_MSG);
            }
        }
        AjaxResult ajaxResult = userService.clickLink(usercode, shareCode);
        return ajaxResult;
    }

    /**
     * 查询可抽奖次数
     *
     * @return
     */
    @RequestMapping("/info")
    public AjaxResult info(@RequestParam String usercode) {
        User user = userService.selectByUsercode(usercode);
        return AjaxResult.successWithData(user);
    }
}
