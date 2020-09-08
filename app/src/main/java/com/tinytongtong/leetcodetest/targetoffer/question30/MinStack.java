package com.tinytongtong.leetcodetest.targetoffer.question30;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 剑指 Offer 30. 包含min函数的栈
 * @Author tinytongtong
 * @Date 2020/9/8 10:42 PM
 * @Version
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!stackMin.isEmpty()) {
            int num = stackMin.peek();
            if (x < num) {
                stackMin.push(x);
            } else {
                stackMin.push(num);
            }
        } else {
            stackMin.push(x);
        }
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
