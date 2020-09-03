package com.tinytongtong.leetcodetest.targetoffer.question03;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description: https://github.com/zhedahht/CodingInterviewChinese2/issues/63
 * 0~(n-1)这个n个数字在没有重复数字的情况下最多需要交换n-1次就可以让所有数字找到自己的位置：最大次数应该是n
 * 验证这个结论
 * @Author tinytongtong
 * @Date 2020/9/3 5:35 PM
 * @Version
 */
public class MaxSwapCountTest {
    /**
     * https://github.com/zhedahht/CodingInterviewChinese2/issues/63
     *
     * 验证方法
     *
     * @param nums
     * @return
     */
    private static int verifyTest(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int swapCount = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 交换元素
                temp = nums[i];
                nums[i] = i;
                i = temp;
                swapCount++;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        /**
         * 0~(n-1)这个n个数字在没有重复数字的情况下最多需要交换n-1次就可以让所有数字找到自己的位置
         */
        // 测试10遍
        for (int m = 0; m < 10; m++) {
            int[] nums1 = new int[100000];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = i;
                list.add(i);
            }
            // 列表乱序
            Collections.shuffle(list);
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = list.get(i);
            }
            // 获取交换次数
            int swapCount = verifyTest(nums1);
            System.out.println("swapCount:" + swapCount);
        }

    }
}
