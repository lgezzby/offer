package com.zjgsu.offer.EightQueen;

import java.util.Arrays;

/**
 * 八皇后问题,不在同一行同一列同一对角线
 */
public class EightQueen {
    public static void main(String[] args) {
        //求取八皇后的全排列
        int[] columnIndex = {0,1,2,3,4,5,6,7};
        permutation(columnIndex,0,columnIndex.length - 1);
    }

    private static void permutation(int[] columnIndex, int pBegin, int pEnd) {
        //排列完成,判断是否满足八皇后
        if (pBegin == pEnd) {
            boolean flag = false;
            for (int i = 0; i < columnIndex.length - 1; i++) {
                for (int j = i + 1; j < columnIndex.length; j++) {
                    if (i - j == columnIndex[i] - columnIndex[j] || j - i == columnIndex[i] - columnIndex[j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                System.out.println(Arrays.toString(columnIndex));
            }
        }

        //全排列
        for (int i = pBegin; i <= pEnd; i++) {
            swap(columnIndex,pBegin,i);
            permutation(columnIndex,pBegin + 1, pEnd);
            swap(columnIndex,pBegin,i);
        }

    }

    private static void swap(int[] columnIndex, int pBegin, int i) {
        int tmp = columnIndex[pBegin];
        columnIndex[pBegin] = columnIndex[i];
        columnIndex[i] = tmp;
    }
}
