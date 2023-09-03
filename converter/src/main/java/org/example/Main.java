package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("변환할 수를 입력하세요 : ");
        String input = scanner.next();
//        System.out.println("적용할 메서드를 선택하세요");
//        Syste®m.out.println("1. decimalToBinary");
//        int index = scanner.nextInt();
//        if(index <= 2){
//        System.out.print("변환할 진수를 입력하세요 : ");
//        int binary = scanner.nextInt();
        System.out.println(Converter.sixteenToTwo(input));
//       }
        scanner.close();
    }
}

//1 010 011 100
//1 010 011 100
