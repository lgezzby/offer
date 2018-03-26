package com.zjgsu.offer.ReplaceBlank;

/**
 * 替换空格
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        char[] str = {'W','e',' ','a','r','e',' ','h','a','p','p','y','.'};
        int num = 0;
        if (str == null || str.length < 0) {
            System.out.println("空字符串");
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                num++;
            }
        }
        char[] newStr = new char[str.length + num * 2];
        for (int i = newStr.length - 1 , j = str.length - 1 ; i >= 0 && j >= 0; i--,j--) {
            //如果是空格,替换为%20
            if (str[j] == ' ') {
                newStr[i] = '0';
                newStr[i-1] = '2';
                newStr[i-2] = '%';
                i = i-2;
            } else {
                newStr[i] = str[j];
            }
        }
        System.out.println(newStr);
    }
}
