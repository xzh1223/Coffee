package com.ichuk.coffee.bean;

/**
 * Created by xzh on 2017/12/11.
 *
 */

public class StringBean {
    private String name;
    private boolean isSelected = false;

    public StringBean(String s, boolean b) {
        this.name = s;
        this.isSelected = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
