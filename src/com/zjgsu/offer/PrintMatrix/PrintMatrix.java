package com.zjgsu.offer.PrintMatrix;

/**
 * 顺时针打印矩阵
 */
public class PrintMatrix {
    public static void printMatrixClockwisely(int[][] number,int row,int column) {
        //特殊情况
        if (number == null || column<= 0 || row <= 0) {
            return;
        }

        int start = 0;

        while (column > start * 2 && row > start * 2) {
            printMatrixInCircle(number, row, column, start);
            start++;
        }

    }

    public static void printMatrixInCircle(int[][] number,int row,int column,int start) {
        int endX = row-1-start;
        int endY = column-1-start;
        //向右是肯定会进行的
        for (int i = start; i <= endX; i++) {
            System.out.println(number[start][i]);
        }
        //判断是否向下(不止1行)
        if (start < endY) {
            for (int i = start+1; i <= endY; i++) {
                System.out.println(number[i][endY]);
            }
        }
        //判断是否向左(且不止1列)
        if (start < endX && start < endY) {
            for (int i = endX-1; i >= start; i--) {
                System.out.println(number[endX][i]);
            }
        }
        //判断是否向上(且不止2行)
        if (start < endX-1 && start < endY) {
            for (int i = endY-1; i >= start+1; i--) {
                System.out.println(number[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] number= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int row = number.length;
        int column = number[0].length;
        printMatrixClockwisely(number,row,column);
    }
}
