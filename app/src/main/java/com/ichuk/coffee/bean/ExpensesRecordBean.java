package com.ichuk.coffee.bean;

/**
 * Created by xzh on 2017/12/18.
 *
 */

public class ExpensesRecordBean {
    private int id;
    private String content;
    private String time;
    private String money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
