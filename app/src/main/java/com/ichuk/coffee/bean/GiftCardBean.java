package com.ichuk.coffee.bean;

import java.io.Serializable;

/**
 * Created by xzh on 2017/12/15.
 *
 */

public class GiftCardBean implements Serializable {
    private int id;
    private String image;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
