package com.ht.lottery.entity;

import com.ht.lottery.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TicketType implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 总数量
     */
    private Integer totalNum;
    /**
     * 每天数量
     */
    private Integer daliyNum;
    /**
     * 每天最大数量
     */
    private Integer daliyNumMax;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    private String startTimeStr;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String endTimeStr;
    /**
     * 开始使用时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date useStartTime;
    private String useStartTimeStr;
    /**
     * 结束使用时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date useEndTime;
    private String useEndTimeStr;
    /**
     * 概率/权重
     */
    private Integer probability;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态:0不可使用,1可使用
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getDaliyNum() {
        return daliyNum;
    }

    public void setDaliyNum(Integer daliyNum) {
        this.daliyNum = daliyNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDaliyNumMax() {
        return daliyNumMax;
    }

    public void setDaliyNumMax(Integer daliyNumMax) {
        this.daliyNumMax = daliyNumMax;
    }

    public String getStartTimeStr() {
        return this.startTime == null ? "" : DateUtil.getDateTime(DateUtil.FORMAT_DATETIME, this.startTime);
    }

    public String getEndTimeStr() {
        return this.endTime == null ? "" : DateUtil.getDateTime(DateUtil.FORMAT_DATETIME, this.endTime);
    }

    public String getUseStartTimeStr() {
        return this.useStartTime == null ? "" : DateUtil.getDateTime(DateUtil.FORMAT_DATETIME, this.useStartTime);
    }

    public String getUseEndTimeStr() {
        return this.useEndTime == null ? "" : DateUtil.getDateTime(DateUtil.FORMAT_DATETIME, this.useEndTime);
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalNum=" + totalNum +
                ", daliyNum=" + daliyNum +
                ", daliyNumMax=" + daliyNumMax +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", useStartTime=" + useStartTime +
                ", useEndTime=" + useEndTime +
                ", probability=" + probability +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}