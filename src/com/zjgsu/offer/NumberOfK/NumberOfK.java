package com.zjgsu.offer.NumberOfK;

/**
 * 计算数组中一共有多少个K
 * 采用二分查找的思路
 */
public class NumberOfK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(arr,3));
    }

    private static int getNumberOfK(int[] arr, int k) {
        //特殊情况
        if (arr.length == 0 || arr == null)
        {
            return -1;
        }

        int firstK = getFirstK(arr,k,0,arr.length-1);
        int lastK = getLastK(arr,k,0,arr.length-1);

        if (firstK != -1 && lastK != -1) {
            int count = lastK - firstK + 1;
            return count;
        }
        return -1;
    }

    private static int getLastK(int[] arr,int k,int low,int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        // 中间值是所要查找的k,继续判断这是不是最后一个k
        if (arr[mid] == k) {
            //是第一个k
            if (mid < arr.length - 1 && arr[mid + 1] != k || mid == arr.length - 1) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        //k值在右侧
        else if (arr[mid] < k) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
        return getLastK(arr,k,low,high);
    }

    private static int getFirstK(int[] arr,int k,int low,int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        // 中间值是所要查找的k,继续判断这是不是第一个k
        if (arr[mid] == k) {
            //是第一个k
            if (mid > 0 && arr[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        //k值在右侧
        else if (arr[mid] < k) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
        return getFirstK(arr,k,low,high);
    }
}
