package com.tinytongtong.leetcodetest.targetoffer.question29;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 剑指 Offer 29. 顺时针打印矩阵
 * @Author tinytongtong
 * @Date 2020/9/8 9:29 PM
 * @Version
 */
public class PrintMatrix {
    private static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] result = new int[rows * columns];
        int[] index = new int[1];
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            printMatrixInCircle(matrix, start, result, index);
            start++;
        }
        return result;
    }

    private static void printMatrixInCircle(int[][] matrix, int start, int[] result, int[] index) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右打印一行：必须步骤
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            result[index[0]++] = number;
        }
        // 从上到下打印一列：最少两行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                result[index[0]++] = number;
            }
        }
        // 从右到左打印一行：最少两行两列
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                result[index[0]++] = number;
            }
        }
        // 从下到上打印一列：最少三行两列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = matrix[i][start];
                result[index[0]++] = number;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}
