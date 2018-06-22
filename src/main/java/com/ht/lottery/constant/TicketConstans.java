package com.ht.lottery.constant;

public class TicketConstans {
    /**
     * 已使用状态
     */
    public static final Integer STATE_USE = 1;
    /**
     * 未使用状态
     */
    public static final Integer STATE_NO_USE = 0;
    /**
     * 已领取状态
     */
    public static final Integer STATE_RECEIVE = 2;
    /**
     * 初始抽奖次数:1次
     */
    public static final Integer TIME_INIT = 1;

    public static final String SHARE_ERROR_MSG = "已经分享过了,请勿重复分享";

    public static final String SYSTEM_UPDATE_ERROR_MSG = "系统修改失败,请稍候重试";

    public static final String SHARE_NO_LOGIN_MSG = "请先登录再点击分享链接";

    public static final String PARAM_ERROR_MSG = "参数错误";

    public static final String PARAM_SHARE_USER_MSG = "分享用户不存在,链接地址异常";

    public static final String TICKET_NO_EXIST = "卡券不存在";
    public static final String TICKET_HAS_USED = "卡券已经使用";
    public static final String TICKET_TIME_AFTER = "卡券已经过期";
    public static final String TICKET_TIME_BEFORE = "卡券未到使用时间";

    public static final String TICKET_TIME_OVER = "没有抽取次数啦";
    public static final String ACTIVITY_NON_EXIST = "不在活动时间";

    public static final String TICKET_RAFFLE_SUCCESS = "卡券抽取成功,请到我的卡券查看";

}
