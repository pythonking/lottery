package com.ht.lottery.entity;

import java.util.Date;

/**
 * 抽奖
 */
public class Raffle {
    public Raffle() {
    }

    public Raffle(String usercode, String ticketCode) {
        this.usercode = usercode;
        this.ticketCode = ticketCode;
    }

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 手机号
     */
    private String usercode;
    /**
     * 优惠券编码
     */
    private String ticketCode;
    /**
     * 状态:0:未使用 1已使用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建时间
     */
    private Date useTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode == null ? null : ticketCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        return "Raffle{" +
                "id=" + id +
                ", usercode='" + usercode + '\'' +
                ", ticketCode='" + ticketCode + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", useTime=" + useTime +
                '}';
    }
}