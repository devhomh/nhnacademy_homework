package org.example;

public class Converter {

    private static double logN(int x, int y) {
        return (int) (Math.log(x) / Math.log(y));
    }

    public static String decimalToBinary(int binary, String decimal){
        int num = Integer.parseInt(decimal);
        String result = "";
        int remainder = 0;
        while(num != 0) {
            remainder = num % binary;
            if(remainder >= 10) {
                char ch = (char) (remainder + 55);
                result = ch + result;
            } else{
                result = remainder + result;
            }
            num /= binary;
        }
        return result;
    }
    public static String binaryToDecimal(int index, String binary) {
        int result = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            int num = binary.charAt(i);
            if(num <= 57 && num >= 48){
                num-= 48;
            } else if(num >= 65 && num <= 70){
                num -= 55;
            }
            result += num * (int) Math.pow(index, length -1 -i);
        }
        return String.valueOf(result);
    }

    public static String twoToEight(String binary) {
        String result = "";
        while(binary.length() % 3 != 0) {
            binary = "0" + binary;
        }
        for (int i = 0; i < binary.length()/3; i++) {
            String str = binary.substring(i * 3, i * 3 + 3);
            result += binaryToDecimal(2, str);
        }
        return result;
    }

    public static String EightToTwo(String binary){
        String result = "";
        for (int i = 0; i < binary.length(); i++) {
            String str = binary.substring(i,i+1);
            String applyStr = decimalToBinary(2, str);
            while(applyStr.length() % 3 != 0) {
                applyStr = "0" + applyStr;
            }
            result += applyStr;
        }
        result = result.substring(result.indexOf("1"));
        return result;
    }

    public static String twoToSixteen(String binary){
        String decimal = binaryToDecimal(2, binary);
        return decimalToBinary(16 , decimal);
    }

    public static String sixteenToTwo(String binary) {
       String decimal = binaryToDecimal(16, binary);
       return decimalToBinary(2, decimal);
    }

    public static String eightToSixteen(String binary){
        String decimal = binaryToDecimal(8, binary);
        return decimalToBinary(16, decimal);
    }
    public static String sixteenToEight(String binary){
        String decimal = binaryToDecimal(16, binary);
        return decimalToBinary(8, decimal);
    }
}
