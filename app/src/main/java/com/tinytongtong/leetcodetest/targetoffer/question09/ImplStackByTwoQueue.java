package com.tinytongtong.leetcodetest.targetoffer.question09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 用两个队列实现栈
 * @Author tinytongtong
 * @Date 2020/9/4 6:28 PM
 * @Version
 */
public class ImplStackByTwoQueue {
    /**
     * 一个队列为空，一个不为空
     * add时相关不为空的队列添加；
     * pop数据时，先把有数据的队列中的元素依次读出来，放入到队列中，最后的一个元素就是需要pop的数据
     */
    private static class CStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public CStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void add(int val) {
            if (!queue1.isEmpty()) {
                queue1.add(val);
            } else {
                queue2.add(val);
            }
        }

        public int pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return -1;
            }
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.add(queue2.poll());
                }
                return !queue2.isEmpty() ? queue2.poll() : -1;
            } else {
                while (queue1.size() > 1) {
                    queue2.add(queue1.poll());
                }
                return !queue1.isEmpty() ? queue1.poll() : -1;
            }
        }

        @Override
        public String toString() {
            return "CStack{" +
                    "queue1=" + queue1 +
                    ", queue2=" + queue2 +
                    '}';
        }
    }

    /**
     * add过程:
     * ①先把数据swap到另一个空的队列。
     * ②将数据add到空的队列。
     * ③将swap的数据swap到新添加的数据上面。
     * remove过程：从不为空的队列中获取元素。
     */
    private static class CStack1 {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public CStack1() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void add(int val) {
            Queue<Integer> empty;
            Queue<Integer> notEmpty;
            if (queue1.isEmpty()) {
                empty = queue1;
                notEmpty = queue2;
            } else {
                empty = queue2;
                notEmpty = queue1;
            }
            // 1、swap
            while (!notEmpty.isEmpty()) {
                empty.add(notEmpty.poll());
            }
            // 2、add
            notEmpty.add(val);
            // 3、swap back
            while (!empty.isEmpty()) {
                notEmpty.add(empty.poll());
            }
        }

        public int pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return -1;
            }
            if (queue1.isEmpty()) {
                return queue2.poll();
            } else {
                return queue1.poll();
            }
        }

        @Override
        public String toString() {
            return "CStack1{" +
                    "queue1=" + queue1 +
                    ", queue2=" + queue2 +
                    '}';
        }
    }

    public static void main(String[] args) {
//        CStack stack = new CStack();
        CStack1 stack = new CStack1();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.add(5);
        stack.add(6);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
