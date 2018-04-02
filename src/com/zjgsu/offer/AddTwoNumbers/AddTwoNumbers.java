package com.zjgsu.offer.AddTwoNumbers;

/**
 * 不用加减乘除做加法
 * 利用位运算
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 17;
        System.out.println(addTwoNumbers(number1,number2));
    }

    private static int addTwoNumbers(int number1, int number2) {
        int sum, carry;
        //分两步加,第一步加数字,第二步加进位(进位一直到没有1为止)
        do {
            carry = (number1 & number2) << 1;
            sum = number1 ^ number2;

            number1 = sum;
            number2 = carry;
        }while (carry != 0);
        return sum;
    }
}
