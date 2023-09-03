package com.nhnacademy.mart;

public class Food {

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    private final String name;
    private final int price;



    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
