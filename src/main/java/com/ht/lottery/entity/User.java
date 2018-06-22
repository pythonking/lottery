package com.ht.lottery.entity;

import java.util.Date;

public class User {
    public User() {
    }

    public User(String mobile, String usercode, String name, Integer num, Date createTime) {
        this.mobile = mobile;
        this.usercode = usercode;
        this.name = name;
        this.num = num;
        this.createTime = createTime;
    }

    public User(String usercode) {
        this.usercode = usercode;
    }

    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 手机唯一标示
     */
    private String usercode;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 抽奖次数
     */
    private Integer num;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户名称
     */
    private String name;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usercode='" + usercode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", num=" + num +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                '}';
    }
}