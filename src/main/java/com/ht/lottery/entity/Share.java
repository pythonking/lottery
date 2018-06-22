package com.ht.lottery.entity;

import java.util.Date;

/**
 * 分享
 */
public class Share {
    public Share() {
    }

    public Share(String usercode, String shareCode) {
        this.usercode = usercode;
        this.shareCode = shareCode;
    }

    public Share(String usercode, String shareCode, Date createTime) {
        this.usercode = usercode;
        this.shareCode = shareCode;
        this.createTime = createTime;
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
     * 分享链接的手机号码
     */
    private String shareCode;
    /**
     * 创建时间
     */
    private Date createTime;

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

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode == null ? null : shareCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", usercode='" + usercode + '\'' +
                ", shareCode='" + shareCode + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}