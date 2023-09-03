package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    // add 메서드 구현
    public void add(Food food){
        foods.add(food);
    }

    // 장바구니에 담은 Food 삭제 구현
    public void delete(Food food){
        foods.remove(food);
    }
}
