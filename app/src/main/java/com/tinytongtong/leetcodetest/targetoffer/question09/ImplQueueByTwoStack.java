package com.tinytongtong.leetcodetest.targetoffer.question09;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 剑指 Offer 09. 用两个栈实现队列
 * @Author tinytongtong
 * @Date 2020/9/4 6:05 PM
 * @Version
 */
public class ImplQueueByTwoStack {

    /**
     * 实现思路：
     * ①stackAdd用来添加
     * ②stackRemove用来获取
     * ③如果stackRemove为空时，就把stackAdd中的元素依次出栈再加入到stackRemove中，然后从stackRemove中获取元素。
     */
    private static class CQueue {
        private Stack<Integer> stackAdd;
        private Stack<Integer> stackRemove;

        public CQueue() {
            stackAdd = new Stack<>();
            stackRemove = new Stack<>();
        }

        public void appendTail(int value) {
            stackAdd.add(value);
        }

        public int deleteHead() {
            if (stackRemove.isEmpty()) {
                while (!stackAdd.isEmpty()) {
                    stackRemove.add(stackAdd.pop());
                }
            }
            return !stackRemove.isEmpty() ? stackRemove.pop() : -1;
        }

        @Override
        public String toString() {
            return "CQueue{" +
                    "stackAdd=" + stackAdd +
                    ", stackRemove=" + stackRemove +
                    '}';
        }
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        obj.appendTail(4);
        obj.appendTail(5);
        obj.appendTail(6);
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        // 无数据了
        System.out.println(obj);
        System.out.println(obj.deleteHead());
        System.out.println(obj);
    }
}
