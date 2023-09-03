package com.nhnacademy.mart;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.*;

public class Customer {

    private static final Logger logger = LoggerFactory.getLogger(Customer.class);
    // 고객 구매 목록
    private final BuyList buyList;

    public Basket getBasket() {
        return basket;
    }

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand){
        // buyList에 있는 Item들을 Basket에 추가하고 foodstand에서 그만큼 삭제.
        logger.info("buyList : {}", buyList.getItems());
        for (BuyList.Item item : buyList.getItems()) {
            String name = item.getName();
            int count = item.getAmount();
            logger.info("Item[name, count] = [{}, {}]", name, count);
            List<Food> pickFoodCollector = foodStand.getFoods()
                    .stream().filter(food -> food.getName().equals(name))
                    .collect(Collectors.toList());
            if(pickFoodCollector.isEmpty()){
                throw new IllegalArgumentException("마트에 없는 물품입니다.");
            }
            if(count > pickFoodCollector.size()){
                throw new IllegalArgumentException("물품의 재고가 부족합니다.");
            }
            Food pickFood = pickFoodCollector.get(0);
            while (count != 0) {
                basket.add(pickFood);
                foodStand.delete(pickFood);
                count--;
            }
        }
    }
    // payTox 메서드 구현
    public void payTox(Counter counter) {
        // Basket에 있는 food들의 가격을 합산해서 카운터에 넘겨 Pay하기.
        int sum = 0;
        for (Food food : basket.getFoods()) {
            sum += food.getPrice();
        }
        if(sum > 20000){
            throw new IllegalArgumentException("계산 금액이 20000원을 초과합니다.");
        }
        logger.trace("Total Price : {}", sum);
        System.out.println("총 가격은 " + sum + "원 입니다.");
        counter.pay(sum);
    }
}
