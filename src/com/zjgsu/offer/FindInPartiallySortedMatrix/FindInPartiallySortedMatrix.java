package com.zjgsu.offer.FindInPartiallySortedMatrix;

/**
 * 二维数组中的查找
 *
 * 从左下或者右上开始查找
 */
public class FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int key = 7;
        //左下开始搜索
        for (int i = arr.length - 1; i >= 0;) {
            for (int j = 0; j < arr[i].length;) {
                //如果key比这个数小
                if (key < arr[i][j]) {
                    i--;
                    if (i < 0) {
                        System.out.println("不存在数字" + key);
                        return;
                    }
                    continue;
                }
                //如果key比这个数大
                else if (key > arr[i][j]) {
                    j++;
                    if (j > arr[i].length - 1) {
                        System.out.println("不存在数字" + key);
                        return;
                    }
                    continue;
                }
                //如果相等
                else {
                    System.out.println("存在数字" + key + ":在[" + (i+1) + "][" + (j+1) + "]处");
                    return;
                }
            }
        }
    }
}
