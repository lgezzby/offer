package com.zjgsu.offer.Power;

/**
 * 实现幂乘(斐波那契数列)
 */
public class Power {
    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        //如果指数为奇数
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    public static double pow(double base, int exponent) {
        double result = 1.0;
        //底是0的情况
        if (equal(base,0.0)) {
            return 0;
        }
        //指数是负数的情况
        if (exponent < 0) {
            result = powerWithUnsignedExponent(base, -exponent);
        }
        //正常情况
        else {
            result = powerWithUnsignedExponent(base,exponent);
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    private static boolean equal(double num1, double num2) {
        if (num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        double value = pow(2,5);
        System.out.println(value);
    }
}
