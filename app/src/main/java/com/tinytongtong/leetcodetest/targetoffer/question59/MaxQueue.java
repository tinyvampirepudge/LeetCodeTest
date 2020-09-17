package com.tinytongtong.leetcodetest.targetoffer.question59;

import java.util.LinkedList;

/**
 * @Description: https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * 剑指 Offer 59 - II. 队列的最大值
 * @Author tinytongtong
 * @Date 2020/9/17 1:38 PM
 * @Version
 */
public class MaxQueue {
    private LinkedList<Integer> maxDeque;
    private LinkedList<Integer> list;

    public MaxQueue() {
        maxDeque = new LinkedList<>();
        list = new LinkedList<>();
    }

    public int max_value() {
        return maxDeque.peekFirst();
    }

    public void push_back(int value) {
        while (!maxDeque.isEmpty() && value >= maxDeque.peekLast()) {
            maxDeque.pollLast();
        }
        list.addLast(value);
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (!maxDeque.isEmpty() && maxDeque.peekFirst().equals(list.peekFirst())) {
            maxDeque.pollFirst();
        }
        return list.pollFirst();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(2);
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(3);
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(4);
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(2);
        System.out.println("pop_front:" + maxQueue.pop_front());
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(6);
        System.out.println("pop_front:" + maxQueue.pop_front());
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(2);
        System.out.println("pop_front:" + maxQueue.pop_front());
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(5);
        System.out.println("pop_front:" + maxQueue.pop_front());
        System.out.println("max_value:" + maxQueue.max_value());
        maxQueue.push_back(1);
        System.out.println("pop_front:" + maxQueue.pop_front());
        System.out.println("max_value:" + maxQueue.max_value());
    }
}
