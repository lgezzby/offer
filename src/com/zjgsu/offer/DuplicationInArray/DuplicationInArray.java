package com.zjgsu.offer.DuplicationInArray;

public class DuplicationInArray {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        int result = findDuplication(arr);
        System.out.println(result);
    }

    private static int findDuplication(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int result = -1;
        for (int i = 0; i < arr.length; ) {
            //如果当前值不等于下标
            if (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    result = arr[i];
                    break;
                }
                else {
                    //交换
                    int tmp = arr[i];
                    arr[i] = arr[tmp];
                    arr[tmp] = tmp;
                }
            }
            else {
                i++;
            }
        }
        return result;
    }
}
