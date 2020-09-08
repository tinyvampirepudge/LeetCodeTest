package com.tinytongtong.leetcodetest.fibonacci;

/**
 * @Description: 青蛙跳台阶问题，每次可以调一级，也可以调两级
 * 剑指Offer面试题9
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author tinytongtong
 * @Date 2020-02-09 01:04
 * @Version
 */
public class FrogJumpStep {

    /**
     * 从上往下计算
     *
     * @param n
     * @return
     */
    public static int jumpFloor(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int valueOne = 1;
        int valueTwo = 2;
        int valueN = 0;

        for (int i = 3; i <= n; i++) {
            valueN = valueOne + valueTwo;
            valueOne = valueTwo;
            valueTwo = valueN;
        }
        return valueN;
    }

    public static void main(String[] args) {
        int n = 3;

        long startTime1 = System.nanoTime();
        int result1 = jumpFloor(n);
        long endTime1 = System.nanoTime();
        System.out.println(String.format("青蛙跳台阶，result1:%d, 耗时:%d", result1, endTime1 - startTime1));
    }
}
