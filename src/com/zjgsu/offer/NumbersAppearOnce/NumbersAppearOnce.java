package com.zjgsu.offer.NumbersAppearOnce;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 一个数组中只有两个数字出现一次,剩下的数字都出现2次,找出出现一次的数字
 */
public class NumbersAppearOnce {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
//        findNumbersAppearOnceHashMap(arr);
        findNumbersAppearOnce(arr);
    }

    /**
     * 利用位运算性质,将两个只出现一次的数字拆到两个子数组中
     * @param arr
     */
    private static void findNumbersAppearOnce(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }

        int resultOfOr = 0;
        for (int value : arr) {
            resultOfOr ^= value;
        }
        int indexOf1 = findFirstBit1Is(resultOfOr);

        //查找两个数字
        int num1 = 0;
        int num2 = 0;
        for (int value : arr) {
            if (isBit1(value, indexOf1)) {
                num1 ^= value;
            } else {
                num2 ^= value;
            }
        }

        System.out.println(num1);
        System.out.println(num2);
    }

    private static boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 0 ? false : true;
    }

    private static int findFirstBit1Is(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    /**
     * 借助HashMap辅助数组实现
     * @param arr
     */
    private static void findNumbersAppearOnceHashMap(int[] arr) {
        //存储数字
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        for (int value : arr) {
            if (!countMap.containsKey(value)) {
                countMap.put(value, 1);
            } else {
                countMap.put(value, countMap.get(value) + 1);
            }
        }

        Iterator iterator = countMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if (value == 1) {
                System.out.println(key);
            }
        }
    }
}
