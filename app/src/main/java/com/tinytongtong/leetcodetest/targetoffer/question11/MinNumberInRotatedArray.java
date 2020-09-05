package com.tinytongtong.leetcodetest.targetoffer.question11;

/**
 * @Description: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 剑指 Offer 11. 旋转数组的最小数字
 * @Author tinytongtong
 * @Date 2020/9/5 6:23 PM
 * @Version
 */
public class MinNumberInRotatedArray {

    private static int minArray(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            // 如果index1、index2和indexMid三个位置的数据相等，则只能顺序查找了
            if (numbers[index1] == numbers[index2] && numbers[index2] == numbers[indexMid]) {
                return minInOrder(numbers, index1, index2);
            }

            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    private static int minInOrder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{3, 4, 5, 1, 2};
        System.out.println(minArray(arrays));

        int[] arrays1 = new int[]{2, 2, 2, 0, 1};
        System.out.println(minArray(arrays1));

        int[] arrays2 = new int[]{1, 0, 1, 1, 1};
        System.out.println(minArray(arrays2));

        int[] arrays3 = new int[]{1, 1, 1, 0, 1};
        System.out.println(minArray(arrays3));
    }
}
