package com.zjgsu.offer.ReorderArray;

import java.util.Arrays;

public class ReorderArray {
    public static int[] reorder(int[] data,int length) {
        if (data == null || length <= 0) {
            return null;
        }
        int low = 0;
        int high = length - 1;
        while (low < high) {
            //找到偶数
            while (!isEven(data[low])) {
                low++;
            }
            while (isEven(data[high])) {
                high--;
            }
            if (low < high) {
                int tmp = data[low];
                data[low] = data[high];
                data[high] = tmp;
            }
        }
        return data;
    }

    private static boolean isEven(int num) {
        if ((num & 1) == 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        int[] reorderData = reorder(data,5);
        System.out.println(Arrays.toString(reorderData));
    }
}
