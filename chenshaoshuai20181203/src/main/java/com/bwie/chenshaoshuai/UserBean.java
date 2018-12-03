package com.bwie.chenshaoshuai;

public class UserBean {
    private String _id;
    private String num;

    public UserBean(String _id, String num) {
        this._id = _id;
        this.num = num;
    }

    public String get_id() {
        return _id;
    }

    public String getNum() {
        return num;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
