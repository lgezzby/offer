package com.zjgsu.offer.RegularExpressionMatching;

/**
 * 正则表达式匹配
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String str = "aaa";
        String pattern1 = "a.a";
        String pattern2 = "ab*ac*a";
        System.out.println(match(str,pattern2));
    }

    /**
     * 递归实现
     */
    private static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        
        return matchCore(str,pattern,0,0);
    }

    private static boolean matchCore(String str, String pattern, int indexI, int indexJ) {
        //结束条件,有一方到达字符串尾部
        if (indexI == str.length() && indexJ == pattern.length()) {
            return true;
        }
        if ((indexI == str.length() && indexJ != pattern.length()) || (indexI != str.length() && indexJ == pattern.length())) {
            return false;
        }

        //*则可选择递归(str+1,pattern)或者(str+1,pattern+2)或者(str,pattern+2)
        if ((indexJ + 1) < pattern.length() && pattern.charAt(indexJ + 1) == '*') {
            //此时判断*前的字符跟pattern中的字符是否一样,
            if (str.charAt(indexI) == pattern.charAt(indexJ) ||
                    (pattern.charAt(indexJ) == '.' && indexI != str.length())) {
                return matchCore(str,pattern,indexI+1,indexJ) ||
                        matchCore(str,pattern,indexI+1,indexJ+2) ||
                        matchCore(str,pattern,indexI,indexJ+2);
            } else {
                return matchCore(str,pattern,indexI,indexJ+2);
            }
        }

        //匹配或者.都继续进行接下来的判断
        if ((str.charAt(indexI) == pattern.charAt(indexJ))
                || (pattern.charAt(indexJ) == '.' && indexI != str.length())) {
            return matchCore(str,pattern,indexI+1,indexJ+1);
        }

        return false;
    }
}
