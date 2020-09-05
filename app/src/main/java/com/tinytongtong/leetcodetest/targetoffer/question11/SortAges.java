package com.tinytongtong.leetcodetest.targetoffer.question11;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 请实现一个排序算法，时间复杂度为O(n)；
 * 对公司所有员工的年龄排序，公司有几万名员工。也就是说数字的大小在一定范围内。
 * 可以使用常量大小的辅助空间，不能超过O(n)
 * @Author tinytongtong
 * @Date 2020/9/5 5:48 PM
 * @Version
 */
public class SortAges {
    private static void sortAges(int[] ages) {
        if (ages == null || ages.length == 0) {
            return;
        }
        int maxAge = 99;
        int timesOfAge[] = new int[maxAge + 1];
        for (int i = 0; i < ages.length; i++) {
            timesOfAge[ages[i]]++;
        }
        int index = 0;
        for (int i = 0; i <= maxAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int maxSize = 1000;
        int ages[] = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            ages[i] = new Random().nextInt(99);
        }
        System.out.println(Arrays.toString(ages));
        sortAges(ages);
        System.out.println(Arrays.toString(ages));
    }
}
