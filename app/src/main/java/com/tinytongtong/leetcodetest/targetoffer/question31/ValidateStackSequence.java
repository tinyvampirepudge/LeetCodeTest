package com.tinytongtong.leetcodetest.targetoffer.question31;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 剑指 Offer 31. 栈的压入、弹出序列
 * @Author tinytongtong
 * @Date 2020/9/9 9:56 AM
 * @Version
 */
public class ValidateStackSequence {
    /**
     * 验证入栈序列和出栈序列
     * ①如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
     * ②如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止；
     * ③如果所有数字都压入栈后，仍然没有找到下一个弹出的序列，那么该序列不可能是一个弹出序列。
     *
     * @param pushed
     * @param popped
     * @return
     */
    private static boolean validate(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        boolean result = false;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex <= popped.length && pushIndex <= pushed.length) {
            if (pushIndex == pushed.length && popIndex == popped.length) {
                result = true;
                break;
            }
            if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                // 直接弹出栈顶元素
                stack.pop();
                popIndex++;
            } else {
                // add to stack
                while (pushIndex < pushed.length) {
                    stack.push(pushed[pushIndex]);
                    if (stack.peek() == popped[popIndex]) {
                        pushIndex++;
                        break;
                    }
                    pushIndex++;
                }
                if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                    stack.pop();
                    popIndex++;
                } else {
                    return false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 1, 2};
        boolean result = validate(pushed, popped);
        System.out.println(result);
    }
}
