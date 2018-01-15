package com.ichuk.coffee.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/14.
 *
 */

public class PointBean {
    private int id;
    private String point;
    private List<CoffeeBean> coffeeBeanList = new ArrayList<>();

    public static class CoffeeBean {
        private int id;
        private String name;
        private int img;
        private String ingredient;
        private String price;

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

        @Override
        public String toString() {
            return "CoffeeBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", img=" + img +
                    ", ingredient='" + ingredient + '\'' +
                    ", price='" + price + '\'' +
                    '}';
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public List<CoffeeBean> getCoffeeBeanList() {
        return coffeeBeanList;
    }

    public void setCoffeeBeanList(List<CoffeeBean> coffeeBeanList) {
        this.coffeeBeanList = coffeeBeanList;
    }
}
