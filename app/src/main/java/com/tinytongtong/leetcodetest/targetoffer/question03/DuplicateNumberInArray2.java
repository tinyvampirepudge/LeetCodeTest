package com.tinytongtong.leetcodetest.targetoffer.question03;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: 剑指 Offer 03. 数组中重复的数字 思考题
 * 在一个长度为n+1的数组里面，所有数字都在1~n的范围内，所以最少有一个元素是重复的，找出任意一个重复数字即可。
 * 不能修改源数组
 * @Author tinytongtong
 * @Date 2020/9/3 5:39 PM
 * @Version
 */
public class DuplicateNumberInArray2 {

    /**
     * 创建长度为n+1的辅助数组，将原数据copy过去，copy过程中将数据插入到对应的下标，如果对应下标已经有数据了，就说明元素重复
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    private static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] >= nums.length) {
                return -1;
            }
        }
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (temps[nums[i] - 1] != 0) {
                return nums[i];
            }
            temps[nums[i] - 1] = nums[i];
        }
        return -1;
    }

    /**
     * 类似二分法的思想，以时间换空间
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    private static int findRepeatNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] >= nums.length) {
                return -1;
            }
        }
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, start, middle);
            // 起点等于终点
            if (end == start) {
                // 有重复元素
                if (count > 1) {
                    return start;
                } else {// 无重复元素，退出
                    break;
                }
            }
            // 改变区间
            if (count > middle - start + 1) {// [start, middle]中有重复元素
                end = middle;
            } else {// (middle, end]中有重复元素
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * start到end范围内数字的个数，[start,end]
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        test(nums);
    }

    private static void test(int[] nums) {
        System.out.println("--------------------start--------------------");
        System.out.println(Arrays.toString(nums));
        // 测试数据
        int result = findRepeatNumber(nums);
        System.out.println(result);

        int result1 = findRepeatNumber1(nums);
        System.out.println(result1);

        System.out.println("--------------------end--------------------");
    }
}
