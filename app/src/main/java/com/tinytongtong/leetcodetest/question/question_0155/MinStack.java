package com.tinytongtong.leetcodetest.question.question_0155;

import java.util.Stack;

/**
 * @Description: 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * 剑指offer第21题
 * @Author tinytongtong
 * @Date 2020-02-05 16:15
 * @Version
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> assistStack;

    public MinStack() {
        stack = new Stack<>();
        assistStack = new Stack<>();
    }

    /**
     * 添加元素
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        if (!assistStack.isEmpty() && assistStack.peek() < x) {
            assistStack.push(assistStack.peek());
        } else {
            assistStack.push(x);
        }
    }

    /**
     * 移除顶部元素
     */
    public void pop() {
        stack.pop();
        assistStack.pop();
    }

    /**
     * 获取栈顶的值
     *
     * @return
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取当前栈中的最小值
     *
     * @return
     */
    public int getMin() {
        if (!assistStack.isEmpty()) {
            return assistStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minStack.getMin():" + minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println("minStack.top():" + minStack.top());    //  --> 返回 0.
        System.out.println("minStack.getMin():" + minStack.getMin());  // --> 返回 -2.
    }
}
