package com.zjgsu.offer.NumberOf1InBinary;

/**
 * 计算二进制中1的个数
 */
public class NumberOf1InBinary {
    public static int numberOf1(int value) {
        int count = 0;
        while (value != 0) {
            count++;
            value = value & (value - 1);
        }
        return count;
    }

//    public static int numberOf1(int value) {
//        int count = 0;
//        int flag = 1;
//        while (flag > 0) {
//            if ((value & flag) != 0) {
//                count++;
//            }
//            flag = flag << 1;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        int count = numberOf1(9);
        System.out.println(count);
    }
}
