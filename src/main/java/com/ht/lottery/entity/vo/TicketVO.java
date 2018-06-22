package com.ht.lottery.entity.vo;

import com.ht.lottery.entity.Ticket;

import java.util.Date;

public class TicketVO extends Ticket {
    /**
     * 名称
     */
    private String name;
    /**
     * 开始使用时间
     */
    private Date useStartTime;
    /**
     * 结束使用时间
     */
    private Date useEndTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

}
