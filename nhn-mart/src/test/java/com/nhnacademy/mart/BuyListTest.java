package com.nhnacademy.mart;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyListTest {
    @Test
    @DisplayName("올바른 입력 값 확인 여부 테스트")
    void inputCheckTest() {
        String str = "양파 2 계란 2 파";
        BuyList buyList = new BuyList();
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> buyList.add(str));
        assertEquals("올바른 Input 값이 아닙니다.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"양파 2 계란 2 파 -1", "양파 0 계란 2 파 4"})
    @DisplayName("수량을 음수로 입력 했을 경우 테스트")
    void negativeAmountTest(String input) {
        BuyList buyList = new BuyList();
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> buyList.add(input));
        assertEquals("올바른 수량을 입력하세요", e.getMessage());
    }
}