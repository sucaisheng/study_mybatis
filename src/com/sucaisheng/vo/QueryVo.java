package com.sucaisheng.vo;

import com.sucaisheng.pojo.User;

public class QueryVo {

    private User user;

    public QueryVo(){}

    public QueryVo(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
