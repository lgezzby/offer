package com.zjgsu.offer.StringToInt;

/**
 * 字符串转数字
 */
public class StringToInt {
    public static boolean g_nState = true;

    public static void main(String[] args) {
        System.out.println(strToInt("-12345678922222222222"));
        System.out.println(g_nState);
    }

    private static int strToInt(String str) {
        //空字符串 或者 ""
        if (str == null || str.equals("")) {
            g_nState = false;
            return 0;
        }
        //判断第一个位置的符号
        boolean symbol = false;
        int num;
        if (str.charAt(0) == '-') {
            symbol = true;
            num = strToIntCore(str,symbol,1);
        } else if (str.charAt(0) == '+') {
            num = strToIntCore(str,symbol,1);
        } else {
            num = strToIntCore(str,symbol,0);
        }
        return num;
    }

    /**
     * 计算数字部分,如果有非法字符,返回0并且设定g_nState
     */
    private static int strToIntCore(String str, boolean symbol, int index) {
        //判断是否是只有符号没有数字
        if (index == 1 && str.length() == 1){
            g_nState = false;
            return 0;
        }

        long sum = 0;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum = sum * 10 + (symbol ? -1 : 1) * (str.charAt(i) - '0');
                //溢出判断
                if ((!symbol && sum > Integer.MAX_VALUE) || (symbol && sum < Integer.MIN_VALUE)) {
                    g_nState = false;
                    return 0;
                }
            }
            else {
                g_nState = false;
                return 0;
            }
        }
        return (int) sum;
    }
}
