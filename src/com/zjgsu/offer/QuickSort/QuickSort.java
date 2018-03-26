package com.zjgsu.offer.QuickSort;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] data,int low,int high) throws Exception {
        if (low > high) {
            throw new Exception("error input.");
        }
        //存储轴
        int key = data[low];
        while (low < high) {
            while (low < high && data[high] >= key) {
                high--;
            }
            //交换比轴小的数到左侧
            data[low] = data[high];
            while (low < high && data[low] <= key) {
                low++;
            }
            //交换比轴大的数到右侧
            data[high] = data[low];
        }
        data[low] = key;
        return low;
    }
    public static void quickSort(int[] data,int low,int high) throws Exception {
        int pos;
        if (low < high) {
            pos = partition(data,low,high);
            quickSort(data,low,pos-1);
            quickSort(data,pos+1,high);
        }
    }
    public static void main(String[] args) throws Exception {
        int[] data = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};
        System.out.println(Arrays.toString(data));
        quickSort(data,0,9);
        System.out.println(Arrays.toString(data));
    }
}
