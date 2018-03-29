package com.zjgsu.offer.BlankPermutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 括号匹配问题
 */
public class BlankPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        List<String> list = new ArrayList<>();
        blankMatch(list, number, number, 0, new char[2 * number]);
        for (String value: list ) {
            System.out.println(value);
        }
    }

    public static void blankMatch(List<String> list,int leftBlank, int rightBlank, int count, char[] buffer) {
        //如果右括号比左括号先出现
        if (rightBlank < leftBlank) {
            return;
        }
        //匹配结束,存当前括号匹配
        if (leftBlank == 0 && rightBlank == 0) {
            String s = String.copyValueOf(buffer);
            list.add(s);
        }
        else {
            //有左括号,就继续输入左括号
            if (leftBlank > 0) {
                buffer[count] = '(';
                blankMatch(list,leftBlank-1,rightBlank,count+1,buffer);
            }
            //右括号比左括号多,就可以输入右括号
            if (rightBlank > leftBlank){
                buffer[count] = ')';
                blankMatch(list,leftBlank,rightBlank-1,count+1,buffer);
            }
        }
    }
}
