package com.zjgsu.offer.ContinuousCards;

import sun.misc.Compare;
import sun.misc.Sort;

/**
 * 判断五张牌是不是顺子
 */
public class ContinuousCards {
    public static void main(String[] args) {
        Integer[] arr = {7,9,0,6,8};
        System.out.println(isContinuous(arr));
    }

    /**
     * 书中的方法
     */
    private static boolean isContinuous(Integer[] arr) {
        if (arr.length == 0 || arr == null) {
            return false;
        }
        //对原数组排序
        Compare compare = new Compare() {
            @Override
            public int doCompare(Object o, Object o1) {
                return (int) o - (int) o1;
            }
        };
        Sort.quicksort(arr, compare);

        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < arr.length && arr[i] == 0; i++) {
            numberOfZero++;
        }

        int small = numberOfZero;
        int big = small + 1;

        while (big < arr.length) {
            //如果两个数相同,则返回false
            if (arr[small] == arr[big]) {
                return false;
            }
            numberOfGap += arr[big] - arr[small] - 1;
            small = big;
            big++;
        }

        return numberOfZero >= numberOfGap ? true : false;
    }
}
