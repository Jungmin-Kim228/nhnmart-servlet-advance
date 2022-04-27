package com.nhnacademy.nhnmart.domain;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }
}
