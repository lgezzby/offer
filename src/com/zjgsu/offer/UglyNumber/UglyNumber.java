package com.zjgsu.offer.UglyNumber;

/**
 * 输出第n个丑数(只能被2,3,5整除)
 * 类似素数打表的方法
 */
public class UglyNumber {
    public static void main(String[] args) {
        int number = findNUglyNumber(1500);
        System.out.println(number);
    }

    private static int findNUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        //丑数表
        int[] uglyArr = new int[index];
        uglyArr[0] = 1;
        int nextUglyIndex = 1;
        int uglyMutiply2Index = 0;
        int uglyMutiply3Index = 0;
        int uglyMutiply5Index = 0;

        while (nextUglyIndex < index) {
            int min = Math.min(Math.min(uglyArr[uglyMutiply2Index] * 2, uglyArr[uglyMutiply3Index] * 3),
                    uglyArr[uglyMutiply5Index] * 5);
            //下一个丑数
            uglyArr[nextUglyIndex] = min;
            while (uglyArr[uglyMutiply2Index] * 2 <= uglyArr[nextUglyIndex]) {
                uglyMutiply2Index++;
            }
            while (uglyArr[uglyMutiply3Index] * 3 <= uglyArr[nextUglyIndex]) {
                uglyMutiply3Index++;
            }
            while (uglyArr[uglyMutiply5Index] * 5<= uglyArr[nextUglyIndex]) {
                uglyMutiply5Index++;
            }

            nextUglyIndex++;
        }
        int ugly = uglyArr[nextUglyIndex - 1];
        return ugly;
    }
}
