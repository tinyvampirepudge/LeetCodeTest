package com.tinytongtong.leetcodetest.targetoffer.question04;

/**
 * @Description: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 剑指 Offer 04. 二维数组中的查找
 * n*m数组，每一行从左到右递增，每一列从上到下递增。
 * 判断二维数组中是否包含某个整数
 * @Author tinytongtong
 * @Date 2020/9/3 9:43 PM
 * @Version
 */
public class FindInTwoDimensionalArray {
    private static boolean findNumberIn2DArray(int[][] arrays, int target) {
        if (arrays == null || arrays.length == 0) {
            return false;
        }

        int rows = arrays.length;
        int columns = arrays[0].length;
        // 从右上角开始
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            if (arrays[row][column] == target) {
                return true;
            } else if (arrays[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean result = findNumberIn2DArray(arrays, 5);
        System.out.println(result);

        boolean result1 = findNumberIn2DArray(arrays, 1);
        System.out.println(result1);

        boolean result2 = findNumberIn2DArray(arrays, 15);
        System.out.println(result2);

        boolean result3 = findNumberIn2DArray(arrays, 18);
        System.out.println(result3);

        boolean result4 = findNumberIn2DArray(arrays, 30);
        System.out.println(result4);

        boolean result5 = findNumberIn2DArray(arrays, 0);
        System.out.println(result5);

        boolean result6 = findNumberIn2DArray(arrays, 31);
        System.out.println(result6);

        boolean result7 = findNumberIn2DArray(arrays, 20);
        System.out.println(result7);
    }
}
