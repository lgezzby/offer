package com.zjgsu.offer.ReverseWordInSetence;

/**
 * 翻转单词
 */
public class ReverseWordInSetence {
    public static void main(String[] args) {
        String str = "I am a student.";

        String[] strArr = str.split(" ");
        for (int i = strArr.length - 1; i >= 0; i--) {
            System.out.print(strArr[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

    //可以用两次翻转的思想实现
}
