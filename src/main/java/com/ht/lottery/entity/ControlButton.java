package com.ht.lottery.entity;

import java.io.Serializable;

public class ControlButton implements Serializable {
    private Integer id;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ControlButton{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
