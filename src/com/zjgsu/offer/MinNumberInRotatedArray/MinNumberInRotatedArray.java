package com.zjgsu.offer.MinNumberInRotatedArray;

/**
 * 用二分查找的方法在旋转数组中查找最小值
 */
public class MinNumberInRotatedArray {
    public static int min(int[] data,int length) throws Exception {
        if (data == null || length <= 0) {
            throw new Exception("error input.");
        }

        int low = 0;
        int high = length - 1;
        int index = low;

        while (data[low] >= data[high]) {
            if (high - low == 1) {
                index = high;
                break;
            }

            index = (low + high) / 2;

            //如果是特殊情况,只能遍历
            if (data[low] == data[high] && data[low] == data[index]) {
                return minInOrder(data,low,high);
            }
            if (data[low] <= data[index]) {
                low = index;
            } else if (data[high] >= data[index]) {
                high = index;
            }
        }
        return data[index];
    }

    private static int minInOrder(int[] data, int low, int high) {
        int result = data[low];
        for (int i = low+1 ; i <= high; i++) {
            if (data[i] < result) {
                result = data[i];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] data = {3,4,5,1,2};
//        int[] data = {1,1,1,0,1};
        System.out.println(min(data,5));
    }
}
