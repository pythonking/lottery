package com.ht.lottery.entity.vo;

import java.util.Date;

public class RaffleUserVO {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 中奖类型
     */
    private String TicketTypeName;
    /**
     * 中奖备注
     */
    private String TicketTypeRemark;
    /**
     * 中奖日期
     */
    private Date createTime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTicketTypeName() {
        return TicketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        TicketTypeName = ticketTypeName;
    }

    public String getTicketTypeRemark() {
        return TicketTypeRemark;
    }

    public void setTicketTypeRemark(String ticketTypeRemark) {
        TicketTypeRemark = ticketTypeRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RaffleUserVO{" +
                "mobile='" + mobile + '\'' +
                ", userName='" + userName + '\'' +
                ", TicketTypeName='" + TicketTypeName + '\'' +
                ", TicketTypeRemark='" + TicketTypeRemark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
