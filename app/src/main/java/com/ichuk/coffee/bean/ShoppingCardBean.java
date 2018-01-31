package com.ichuk.coffee.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/30.
 */

public class ShoppingCardBean {
    private int id;
    private String shopName;
    private List<CoffeeBean> coffeeBeanList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<CoffeeBean> getCoffeeBeanList() {
        return coffeeBeanList;
    }

    public void setCoffeeBeanList(List<CoffeeBean> coffeeBeanList) {
        this.coffeeBeanList = coffeeBeanList;
    }

    @Override
    public String toString() {
        return "ShoppingCardBean{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", coffeeBeanList=" + coffeeBeanList +
                '}';
    }
}
