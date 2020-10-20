package com.tinytongtong.leetcodetest.targetoffer.question67;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 剑指 Offer 67. 把字符串转换成整数
 * @Author tinytongtong
 * @Date 2020/9/20 4:05 PM
 * @Version
 */
public class StrToInt {
    private static int strToInt(String str) {
        int result = 0, boundary = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) {
            return 0;
        }
        // 去除首部空格
        while (i < length && str.charAt(i) == ' ') i++;
        if (i >= length) return 0;
        // 获取符号
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        // 拼接数字
        for (int j = i; j < length; j++) {
            // 非法字符
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
            // 越界处理
            if (result > boundary || (result == boundary && str.charAt(j) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 拼接数据
            result = result * 10 + (str.charAt(j) - '0');
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(strToInt("42"));
        System.out.println(strToInt("      -42"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("words with 987"));
        System.out.println(strToInt("-91283472332"));
        System.out.println(strToInt("   "));
    }
}
