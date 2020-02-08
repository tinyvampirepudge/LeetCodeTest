package com.tinytongtong.leetcodetest.search_a_2d_matrix;

/**
 * @Description: 二位数组的查找
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 剑指offer第三题
 * @Author wangjianzhou@qding.me
 * @Date 2020-02-08 13:34
 * @Version
 */
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) {
            return false;
        }

        int rowIndex = 0;
        int columnIndex = matrix[0].length - 1;
        while (rowIndex < matrix.length && columnIndex >= 0) {
            if (matrix[rowIndex][columnIndex] == target) {
                return true;
            } else if (matrix[rowIndex][columnIndex] > target) {
                columnIndex--;
            } else if (matrix[rowIndex][columnIndex] < target) {
                rowIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = -1;
        boolean result = searchMatrix(matrix, target);
        System.out.println(String.format("target:%s, result:%b", target, result));
    }
}
