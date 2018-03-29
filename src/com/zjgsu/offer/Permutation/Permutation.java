package com.zjgsu.offer.Permutation;

import java.util.Arrays;

/**
 * 字符串的排列
 */
public class Permutation {
    public static void main(String[] args) {
        char[] str = {'a','b','c'};
        permutation(str);
    }

    private static void permutation(char[] pStr) {
        if (pStr.length == 0) {
            return;
        }
        permutation(pStr,0, pStr.length - 1);
    }

    private static void permutation(char[] pStr, int pBegin, int pEnd) {
        if (pBegin == pEnd) {
            System.out.println(Arrays.toString(pStr));
        }
        for (int i = pBegin; i <= pEnd; i++) {
            //固定子串中的第一个字符
            swap(pStr,i,pBegin);
            permutation(pStr,pBegin+1,pEnd);
            swap(pStr,i,pBegin);
        }
    }

    private static void swap(char[] pStr, int i, int pBegin) {
        char tmp = pStr[i];
        pStr[i] = pStr[pBegin];
        pStr[pBegin] = tmp;
    }
}
