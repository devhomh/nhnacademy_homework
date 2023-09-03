package com.nhnacademy.mart;

import org.slf4j.*;

public class Counter {
    private static final Logger logger = LoggerFactory.getLogger(Counter.class);
    //pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public void pay(int payment){
        int balance = 20000 - payment;
        logger.trace("결제 후 잔액 : {}", balance);
        System.out.println("고객님 결제 후 잔액 : " + balance + "원");
    }
}
