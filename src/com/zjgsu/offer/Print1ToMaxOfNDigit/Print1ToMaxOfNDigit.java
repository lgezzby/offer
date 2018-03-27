package com.zjgsu.offer.Print1ToMaxOfNDigit;

/**
 * 输出从1到最大N位数
 * 字符数组实现
 */
public class Print1ToMaxOfNDigit {
    public static void print1ToMaxOfNDigit(int n) {
        if (n <= 0) {
            return;
        }
        //初始化0...0
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }

    private static void printNumber(char[] number) {
        boolean beginning = false;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != '0' && beginning == false) {
                beginning = true;
            }
            if (beginning) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    private static boolean increment(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;
        for (int i = number.length-1; i >= 0; i--) {
            int nSum = number[i] - '0' + takeOver;
            if (i == number.length-1) {
                nSum++;
            }
            if (nSum >= 10) {
                //溢出
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    takeOver = 1;
                    number[i] = (char) (nSum + '0');
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    /**
     *递归实现
     */
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitRecursively(number,n,0);
        }
    }

    public static void print1ToMaxOfNDigitRecursively(char[] number,int length,int index) {
        if (index == length-1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1] = (char) (i + '0');
            print1ToMaxOfNDigitRecursively(number,length,index+1);
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
}
