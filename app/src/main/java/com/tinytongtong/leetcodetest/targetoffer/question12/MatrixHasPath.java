package com.tinytongtong.leetcodetest.targetoffer.question12;

/**
 * @Description: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 剑指 Offer 12. 矩阵中的路径
 * @Author tinytongtong
 * @Date 2020/9/5 9:44 PM
 * @Version
 */
public class MatrixHasPath {
    private static boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1 || str == null) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[] pathLength = new int[1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, i, j, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] matrix, int row, int col, String str, int[] pathLength, boolean[][] visited) {
        if (pathLength[0] == str.length()) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(pathLength[0]) && !visited[row][col]) {
            pathLength[0]++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, row + 1, col, str, pathLength, visited);
            if (!hasPath) {
                --pathLength[0];
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String str = "ABCCED";
        boolean result = hasPath(matrix, str);
        System.out.println(result);

        char[][] matrix1 = new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        };
        String str1 = "ABCCED";
        boolean result1 = hasPath(matrix1, str1);
        System.out.println(result1);
    }
}
