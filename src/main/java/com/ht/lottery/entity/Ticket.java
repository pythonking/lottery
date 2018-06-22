package com.ht.lottery.entity;

import java.util.Date;

/**
 * 优惠券
 */
public class Ticket {
    public Ticket() {
    }

    public Ticket(Integer typeId, Integer status) {
        this.typeId = typeId;
        this.status = status;
    }

    public Ticket(String code, Integer typeId) {
        this.code = code;
        this.typeId = typeId;
    }


    /**
     *自增主键
     */
    private Integer id;
    /**
     *编码
     */
    private String code;
    /**
     *类型id
     */
    private Integer typeId;
    /**
     *状态:0:未使用 1已使用
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", typeId=" + typeId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", useTime=" + useTime +
                '}';
    }
}