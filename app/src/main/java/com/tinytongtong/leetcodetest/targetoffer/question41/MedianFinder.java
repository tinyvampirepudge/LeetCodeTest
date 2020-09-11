package com.tinytongtong.leetcodetest.targetoffer.question41;

import android.annotation.SuppressLint;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * 剑指 Offer 41. 数据流中的中位数
 * 把数据分成两部分，左侧使用最大堆，右侧使用最小堆，左右的数量相差最大为1。
 * 为了实现平均分配，数据的总数目为偶数时把新数据插入最小堆，否则插入最大堆。
 * @Author tinytongtong
 * @Date 2020/9/11 10:05 AM
 * @Version
 */
public class MedianFinder {
    private PriorityQueue<Integer> queueMax;
    private PriorityQueue<Integer> queueMin;
    private int count = 0;

    @SuppressLint("NewApi")
    public MedianFinder() {
        queueMax = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queueMin = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if ((count & 1) == 0) { // 添加进右侧的最小堆
            if (!queueMax.isEmpty() && num < queueMax.peek()) {
                queueMax.add(num);
                num=queueMax.poll();
            }
            queueMin.add(num);
        } else {// 添加进左侧的最大堆
            if (!queueMin.isEmpty() && num > queueMin.peek()) {
                queueMin.add(num);
                num = queueMin.poll();
            }
            queueMax.add(num);
        }
        count++;
    }

    public double findMedian() {
        if (count > 0) {
            if ((count & 1) == 1) {
                return queueMin.peek();
            } else {
                if (!queueMax.isEmpty() && !queueMin.isEmpty()) {
                    return (queueMax.peek() + queueMin.peek()) / 2.0;
                }
                if (!queueMax.isEmpty()) {
                    return queueMax.peek();
                }
                if (!queueMin.isEmpty()) {
                    return queueMin.peek();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
