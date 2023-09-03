package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyList {

    private static final Logger logger = LoggerFactory.getLogger(BuyList.class);

    private final ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    // add 메서드 생성
    public void add(String input){
        StringTokenizer st = new StringTokenizer(input);
        if(st.countTokens() % 2 != 0){
            throw new IllegalArgumentException("올바른 Input 값이 아닙니다.");
        }
        while(st.hasMoreTokens()){
            String name = st.nextToken();
            int amount = st.hasMoreTokens() ?Integer.parseInt(st.nextToken()) : 0;
            if(amount <= 0){
                throw new IllegalArgumentException("올바른 수량을 입력하세요");
            }
            logger.info("Item[name, amount] = [{}, {}]", name, amount);
            Item item = new Item(name, amount);
            items.add(item);
        }
    }

    public static class Item {

        private final String name;
        private final int amount;
        public String getName() {
            return name;
        }
        public int getAmount() {
            return amount;
        }
        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }


}
