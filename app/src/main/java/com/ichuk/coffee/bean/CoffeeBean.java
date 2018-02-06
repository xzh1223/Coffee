package com.ichuk.coffee.bean;

import java.io.Serializable;

/**
 * Created by xzh on 2017/12/5.
 *
 */

public class CoffeeBean implements Serializable {
    private int id;
    private String name;
    private int img;
    private String ingredient;
    private String price;
    public int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CoffeeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img=" + img +
                ", ingredient='" + ingredient + '\'' +
                ", price='" + price + '\'' +
                ", num=" + num +
                '}';
    }
}
