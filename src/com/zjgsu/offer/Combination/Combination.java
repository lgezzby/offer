package com.zjgsu.offer.Combination;

import java.util.Stack;

/**
 * 字符串的组合
 */
public class Combination {
    public static void main(String[] args) {
        char[] str = {'a','b','c'};
        combination(str);
    }

    private static void combination(char[] str) {
        if (str.length == 0){
            return;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 1; i <= str.length; i++) {
            combination(str,0,i,stack);
        }
    }

    private static void combination(char[] str,int begin,int number,Stack stack) {
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }
        if (begin == str.length) {
            return;
        }
        //加上当前字符
        stack.push(str[begin]);
        combination(str,begin + 1,number - 1,stack);
        //不加上当前字符
        stack.pop();
        combination(str,begin + 1,number,stack);
    }
}
