package com.zjgsu.offer.SortArrayForMinNumber;

import com.sun.deploy.util.StringUtils;
import sun.misc.Compare;
import sun.misc.Sort;

/**
 * 把数组排成最小的数
 */
public class SortArrayForMinNumber {
    public static void main(String[] args) {
        int[] arr = {3,32,321};
        printMinNumber(arr);
    }

    /**
     * 打印最小的数
     */
    private static void printMinNumber(int[] arr) {
        String[] strArr = new String[arr.length];
        //字符串转换
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = arr[i] + "";
        }

        //定义比较规则
        Compare compare = new Compare() {
            @Override
            public int doCompare(Object o, Object o1) {
                String str1 = o.toString() + o1.toString();
                String str2 = o1.toString() + o.toString();
                return str1.compareTo(str2);
            }
        };

        //快排实现字符串比较,字符串小的先输出可以保证数最小
        Sort.quicksort(strArr,compare);

        //快排后输出
        for (String value : strArr) {
            System.out.print(value);
        }
    }

}
