package com.zjgsu.offer.MoreThanHalfNumber;

/**
 * 求解数组中个数超过一半的个数
 */
public class MoreThanHalfNumber {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,1,3,1,4,1,5,1,6,1,1,2,2,3,1,1,6,1};
//        int number = moreThanHalfNumber(arr);
        int number = moreThanHalfNumberPartition(arr);
        if (checkMoreThanHalfNumber(number,arr)) {
            System.out.println(number);
        } else {
            System.out.println("No number more than half.");
        }

    }

    /**
     * 利用快排性质查找n/2处的元素
     * @param arr
     * @return
     */
    private static int moreThanHalfNumberPartition(int[] arr) throws Exception {
        //特殊情况
        if (arr == null || arr.length == 0) {
            throw new Exception("wrong array.");
        }
        int start = 0;
        int end = arr.length - 1;
        int middle = arr.length >> 1;
        int index = partition(arr,start,end);

        while (index != middle) {
            //index在middle右边,继续排列左侧
            if (index > middle) {
                end = index - 1;
                index = partition(arr,start,end);
            }
            else {
                start = index + 1;
                index = partition(arr,start,end);
            }
        }

        int result = arr[middle];
        return result;
    }

    /**
     * 划分
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) throws Exception {
        if (low > high) {
            throw new Exception("error input.");
        }
        //存储轴
        int key = arr[low];
        while(low < high) {
            while (low < high && arr[high] >= key) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= key) {
                low++;
            }
            arr[high] = arr[low];
        }
        //分隔的位置
        arr[low] = key;
        return low;
    }

    /**
     * 判断该数字是否超过一半
     * @param number
     * @param arr
     * @return
     */
    private static boolean checkMoreThanHalfNumber(int number, int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (number == value) {
                count++;
            }
        }
        if (count > (arr.length >> 1)) {
            return true;
        }
        return false;
    }

    /**
     * 利用数组特性求解
     * @return
     */
    private static int moreThanHalfNumber(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("wrong array");
        }
        int count = 0;
        int curNum = 0;
        for (int value : arr) {
            if (count == 0) {
                curNum = value;
                count++;
            }
            //判断是否跟记录数据相同
            else {
                if (value == curNum) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return curNum;
    }
}
