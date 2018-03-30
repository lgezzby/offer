package com.zjgsu.offer.KLeastNumbers;

import java.util.Arrays;

/**
 * 寻找最小的K个数字
 */
public class KLeastNumbers {
    public static void main(String[] args) throws Exception {
        int[] arr = {4,3,2,6,5,7,8,1,0};
        int k = 3;
        System.out.println(Arrays.toString(findKLeastNumbers(arr, k,0,arr.length - 1)));
    }

    /**
     * 查找最小的K个数字 O(n)
     */
    private static int[] findKLeastNumbers(int[] arr, int k, int begin, int end) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("error input.");
        }

        int index = partition(arr,begin,end);
        //index还未定位到k-1的位置
        while (index != k - 1) {
            if (index > k - 1) {
                index = partition(arr, begin,index - 1);
            } else {
                index = partition(arr,index + 1, end);
            }
        }

        return Arrays.copyOfRange(arr,0,index + 1);
    }

    /**
     *  划分
     */
    private static int partition(int[] arr, int low, int high) throws Exception {
        if (low > high) {
            throw new Exception("error input");
        }

        //存储轴
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= key) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;

        return low;
    }
}
