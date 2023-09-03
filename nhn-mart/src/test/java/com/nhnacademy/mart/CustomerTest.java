package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import jdk.jshell.spi.ExecutionControlProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    @DisplayName("물품 확인 테스트")
    void pickFoodCheckTest() {
        BuyList.Item item = new BuyList.Item("마늘", 2);
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        FoodStand foodStand = mart.getFoodStand();
        List<Food> pickFoodCollector = foodStand.getFoods()
                .stream().filter(food -> food.getName().equals(item.getName()))
                .collect(Collectors.toList());
        Assertions.assertTrue(pickFoodCollector.isEmpty());
    }

    @Test
    @DisplayName("물품 재고 테스트")
    void inventoryTest() {
        BuyList.Item item = new BuyList.Item("양파 ", 5);
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        FoodStand foodStand = mart.getFoodStand();
        List<Food> pickFoodCollector = foodStand.getFoods()
                .stream().filter(food -> food.getName().equals(item.getName()))
                .collect(Collectors.toList());
        Assertions.assertTrue(item.getAmount() > pickFoodCollector.size());
    }

    @Test
    @DisplayName("한도 초과 테스트")
    void limitExcess() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        String str = "양파 2 계란 4 파 9";
        BuyList buyList = new BuyList();
        buyList.add(str);
        Customer tester = new Customer(buyList);
        tester.bring(mart.provideBasket());
        tester.pickFoods(mart.getFoodStand());
        Basket basket = tester.getBasket();
        int sum = 0;
        for (Food food : basket.getFoods()) {
            sum += food.getPrice();
        }
        Assertions.assertTrue(sum > 20000);
    }
}