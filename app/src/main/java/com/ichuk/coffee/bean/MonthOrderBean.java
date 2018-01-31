package com.ichuk.coffee.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2017/12/13.
 *
 */

public class MonthOrderBean {
    private int id;
    private String year;
    private String month;
    private List<CoffeeBean> coffeeBeanList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<CoffeeBean> getCoffeeBeanList() {
        return coffeeBeanList;
    }

    public void setCoffeeBeanList(List<CoffeeBean> coffeeBeanList) {
        this.coffeeBeanList = coffeeBeanList;
    }

    @Override
    public String toString() {
        return "MonthOrderBean{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", coffeeBeanList=" + coffeeBeanList +
                '}';
    }

    public static class CoffeeBean{
        private int id;
        private String name;
        private int img;
        private String ingredient;
        private String price;
        private int num;
        public boolean isSelected;

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

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
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
                    ", isSelected=" + isSelected +
                    '}';
        }
    }
}
