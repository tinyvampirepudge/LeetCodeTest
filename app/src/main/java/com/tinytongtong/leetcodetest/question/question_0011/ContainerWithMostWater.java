package com.tinytongtong.leetcodetest.question.question_0011;

/**
 * @Description: https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 * @Author tinytongtong
 * @Date 2020/9/1 11:25 AM
 * @Version
 */
public class ContainerWithMostWater {
    /**
     * 双指针、每次移动短边
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 区域要取最大值
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            // 向中间移动短边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int count = maxArea(nums);
        System.out.println(count);
        System.out.println("------------------------------------");

    }
}
