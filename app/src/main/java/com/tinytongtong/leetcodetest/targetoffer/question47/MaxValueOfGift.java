package com.tinytongtong.leetcodetest.targetoffer.question47;

/**
 * @Description: https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 剑指 Offer 47. 礼物的最大价值
 * @Author tinytongtong
 * @Date 2020/9/13 10:38 AM
 * @Version
 */
public class MaxValueOfGift {
    /**
     * 迭代解法：需要同等大小的辅助数组
     * 时间复杂度O(mn)
     * 空间复杂度O(mn)
     *
     * @param grid
     * @return
     */
    private static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] values = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = values[i - 1][j];
                }
                if (j > 0) {
                    left = values[i][j - 1];
                }
                int max = up > left ? up : left;
                values[i][j] = grid[i][j] + max;
            }
        }
        return values[rows - 1][columns - 1];
    }

    /**
     * 迭代解法：需要一个大小为列数的一维数组
     * 时间复杂度O(mn)
     * 空间复杂度O(n)
     *
     * @param grid
     * @return
     */
    private static int maxValue1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[] values = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = values[j];
                }
                if (j > 0) {
                    left = values[j - 1];
                }
                int max = up > left ? up : left;
                values[j] = grid[i][j] + max;
            }
        }
        return values[columns - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        int result = maxValue(grid);
        System.out.println(result);
        System.out.println(maxValue1(grid));
    }
}
