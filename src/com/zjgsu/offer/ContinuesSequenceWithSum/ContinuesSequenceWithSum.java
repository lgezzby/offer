package com.zjgsu.offer.ContinuesSequenceWithSum;

/**
 * 打印出所有和为s的连续正整数
 * 两个指针实现
 */
public class ContinuesSequenceWithSum {
    public static void main(String[] args) {
        int n = 15;
        findContinuesSequenceWithSum(n);
    }

    private static void findContinuesSequenceWithSum(int n) {
        //错误输入
        if (n < 2) {
            return;
        }

        int firstIndex = 1;
        int lastIndex = 2;
        int mid = (n + 1) / 2;
        int curSum = firstIndex + lastIndex;

        //最小的数都已经超过一半了
        while (firstIndex < mid) {
            if (curSum == n) {
                printContinuesSequence(firstIndex, lastIndex);
                curSum -= firstIndex;
                firstIndex++;
            }
            //比n要小,此时要覆盖更多的数
            else if (curSum < n) {
                lastIndex++;
                curSum += lastIndex;
            }
            else {
                curSum -= firstIndex;
                firstIndex++;
            }
        }
    }

    private static void printContinuesSequence(int firstIndex, int lastIndex) {
        for (int i = firstIndex; i <= lastIndex; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
