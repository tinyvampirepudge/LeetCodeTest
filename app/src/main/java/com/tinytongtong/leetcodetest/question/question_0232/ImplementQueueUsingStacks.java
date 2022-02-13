package com.tinytongtong.leetcodetest.question.question_0232;

import java.util.Stack;

/**
 * @Description: 232. 用栈实现队列
 * 用栈是先链表
 * 剑指Offer面试题7
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author tinytongtong
 * @Date 2020-02-08 21:20
 * @Version
 */
public class ImplementQueueUsingStacks {
    /**
     * push操作：直接放入stack1
     * pop操作：
     * ————如果stack2不为空，直接stack2.pop()；
     * ————如果stack2为空，则先将stack1的所有数据依次压入stack2, 然后stack2.pop();
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
