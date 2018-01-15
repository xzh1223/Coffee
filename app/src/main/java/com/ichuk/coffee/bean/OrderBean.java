package com.ichuk.coffee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/12.
 *
 */

public class OrderBean implements Serializable {
    private int id;
    private String shopImage;
    private String shopName;
    private int type;
    private List<CoffeeBean> coffeeBeanList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<CoffeeBean> getCoffeeBeanList() {
        return coffeeBeanList;
    }

    public void setCoffeeBeanList(List<CoffeeBean> coffeeBeanList) {
        this.coffeeBeanList = coffeeBeanList;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", shopImage='" + shopImage + '\'' +
                ", shopName='" + shopName + '\'' +
                ", type=" + type +
                ", coffeeBeanList=" + coffeeBeanList +
                '}';
    }
}
