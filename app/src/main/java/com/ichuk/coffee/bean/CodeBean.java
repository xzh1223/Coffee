package com.ichuk.coffee.bean;

/**
 * Created by xzh on 2018/2/6.
 */

public class CodeBean {
    private int id;
    private String code;
    public boolean isChecked = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
