package com.tinytongtong.leetcodetest.question_0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @Author tinytongtong
 * @Date 2020-02-05 10:15
 * @Version
 */
public class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        // 存储数据值和对应的角标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 算出对应的差值，查找是否已经存在了
            int key = target - nums[i];
            // 对应数字已存在于map中，表示匹配成功，退出循环，返回结果
            if (map.get(key) != null) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("result:result[0]:" + result[0] + ",result[1]:" + result[1]);
    }
}
