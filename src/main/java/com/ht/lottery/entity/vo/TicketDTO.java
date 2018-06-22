package com.ht.lottery.entity.vo;

public class TicketDTO {
    /**
     * 奖品类型
     */
    private Integer typeId;
    /**
     * 奖品名称
     */
    private String typeName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 类型id
     */
    private Integer status;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", num=" + num +
                ", status=" + status +
                '}';
    }
}
