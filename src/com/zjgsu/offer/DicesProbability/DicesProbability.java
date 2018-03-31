package com.zjgsu.offer.DicesProbability;

/**
 * n个骰子的点数,及出现的概率
 */
public class DicesProbability {
    public static void main(String[] args) {
        int number = 6;
        printProbability(number);
    }

    private static void printProbability(int number) {
        if (number < 1){
            return;
        }

        int g_maxValue = 6;
        //一共有需要下标到number * g_maxValue
        int[][] probabilities = new int[2][number * g_maxValue + 1];
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++) {
            probabilities[flag][i] = 1;
        }

        //剩余的骰子
        for (int k = 2; k <= number; k++) {
            //不可能存在小于k的和
            for (int i = 0; i < k; i++) {
                probabilities[1-flag][k] = 0;
            }

            for (int i = k; i <= g_maxValue * k; i++) {
                probabilities[1-flag][i] = 0;
                //由之前的g_maxValue值有关
                for (int j = 1; j <= i && j <= g_maxValue; j++) {
                    probabilities[1-flag][i] += probabilities[flag][i-j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.println(ratio);
        }
    }
}
