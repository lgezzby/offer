package com.zjgsu.offer.Accumulate;

/**
 * 累加(条件限制)
 */
public class Accumulate {
    public static class Temp {
        private static int N;
        private static int SUM;

        public Temp() {
            N++;
            SUM += N;
        }

        public static void reset() {
            N = 0;
            SUM = 0;
        }

        public static int getSum() {
            return SUM;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Temp.reset();
        //Java对象数组不调用构造函数
        Temp[] temp = new Temp[n];
        System.out.println(Temp.getSum());
    }
}
