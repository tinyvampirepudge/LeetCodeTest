package com.tinytongtong.leetcodetest.targetoffer.question13;

/**
 * @Description: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 剑指 Offer 13. 机器人的运动范围
 * @Author tinytongtong
 * @Date 2020/9/6 12:44 PM
 * @Version
 */
public class RobotMovingCount {

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count = 1
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    /**
     * 判断机器人能否进入坐标为[row，col]
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = movingCount(5, 30, 40);
        System.out.println(result);
    }
}
