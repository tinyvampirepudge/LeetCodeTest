package com.tinytongtong.leetcodetest.inverse_pairs;

/**
 * @Description: 逆序对
 * 剑指Offer第36题
 * LeetCode第629题
 * https://leetcode-cn.com/problems/k-inverse-pairs-array/
 * @Author wangjianzhou@qding.me
 * @Date 2020-02-06 16:06
 * @Version
 */
public class InversePairs {
    public static int inversePairs(int[] data, int length) {
        if (data == null || length < 0) {
            return 0;
        }

        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = data[i];
        }

        int count = inversesPairsCore(data, copy, 0, length - 1);
        return count;
    }

    /**
     * 递归调用的方法
     * 返回start-end之间数据的逆序对
     * 先进行升序排序，再进行比对
     *
     * @param data  原数据
     * @param copy  辅助数组，用来承装排好序的数据
     * @param start 起始角标
     * @param end   结束角标
     * @return
     */
    public static int inversesPairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        // 将数组分为两部分，这个是第一部分的长度
        int length = (end - start) / 2;

        // 获取左右子数组的逆序对数，递归调用
        // 这里需要格外注意，依次传入的是copy和data，不是data和copy
        int left = inversesPairsCore(copy, data, start, start + length);
        int right = inversesPairsCore(copy, data, start + length + 1, end);

        // i初始化为前半段最后一个数字的下标
        int i = start + length;
        // j初始化为后半段最后一个数字的下标
        int j = end;
        // 辅助数组从右向左复制，这个是起点
        int indexCopy = end;
        // 左右数组之间的的逆序对数
        int count = 0;
        // 开始复制
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                // 右侧数组当前的数字全部小于左侧的数字，所以都是逆序对
                count += j - start - length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }

        // 将剩下的数据copy进辅助数组
        for (; i >= start; --i) {
            copy[indexCopy--] = data[i];
        }

        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        int[] data = new int[]{7, 5, 6, 4};
        int count = inversePairs(data, data.length);
        System.out.println("count:" + count);
    }
}
