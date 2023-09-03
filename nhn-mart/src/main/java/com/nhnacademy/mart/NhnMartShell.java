package com.nhnacademy.mart;

import java.util.Scanner;

/**
 * NhnMart.
 *
 * @author devhomh
 * @version 1.0
 */
public class NhnMartShell {

    /**
     * NhnMart 실행 메인 클래스.
     * */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // 본인 이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer jinWoo = new Customer(buyList);

        // 장바구니를 챙긴다.
        jinWoo.bring(mart.provideBasket());

        // 식품을 담는다.
        jinWoo.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        jinWoo.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // Scanner 입력을 받아 buyList 만들기
        Scanner scanner = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        String input = scanner.nextLine();

        BuyList buyList = new BuyList();

        buyList.add(input);
        return buyList;
    }
}
