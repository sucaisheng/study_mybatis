package com.sucaisheng.pojo;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private int userId;
    private String ono;
    private String creattime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", ono='" + ono + '\'' +
                ", creattime='" + creattime + '\'' +
                '}';
    }
}
