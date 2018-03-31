package com.zjgsu.offer.InversePairs;

import java.util.Arrays;

public class InversePairs {
    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        System.out.println(inversePairs(arr, arr.length));
    }

    private static int inversePairs(int[] arr, int length) {
        if (arr == null || length < 0) {
            return 0;
        }

        int[] copy = Arrays.copyOf(arr,length);

        int count = inversePairsCore(arr, copy, 0, length - 1);

        return count;
    }

    private static int inversePairsCore(int[] arr, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = arr[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = inversePairsCore(copy, arr, start, start + length);
        int right = inversePairsCore(copy, arr, start + length + 1, end);

        //初始化前半段和后半段最后一个字的下标
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (arr[i] > arr[j]) {
                copy[indexCopy--] = arr[i--];
                count = count + j - start  - length;
            } else {
                copy[indexCopy--] = arr[j--];
            }
        }

        for (; i >= start; --i) {
            copy[indexCopy--] = arr[i];
        }

        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = arr[j];
        }

        return left + right + count;
    }
}
