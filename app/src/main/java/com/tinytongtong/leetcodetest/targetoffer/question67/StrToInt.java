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
        return 0;
    }

    public static void main(String[] args) {
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
