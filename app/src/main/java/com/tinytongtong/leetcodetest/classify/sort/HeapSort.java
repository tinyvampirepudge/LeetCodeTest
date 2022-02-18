package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;

/**
 * @Description: 堆排序
 * @Author wangjianzhou@didichuxing.com
 * @Date 2/18/22 8:10 AM
 * @Version
 */
public class HeapSort {
    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        System.out.println(heap.toString());

        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.toString());
    }

    /**
     * 大顶堆.
     * 根节点的元素最大
     */
    private static class Heap {
        int[] a; // 数据容器，从下标1开始存储数据
        int n; // 堆可以存储的最大数据个数
        int count; // 堆中已经存储的数据格式

        public Heap(int capacity) {
            a = new int[capacity + 1];
            n = capacity;
            count = 0;
        }

        public void insert(int data) {
            if (count >= n) { // 堆满了
                return;
            }
            count++;
            // 从下往上堆化。
            // 添加给最后一个元素
            a[count] = data;
            int i = count;
            while (i > 0 && i / 2 > 0 && a[i] > a[i / 2]) {
                int temp = a[i];
                a[i] = a[i / 2];
                a[i / 2] = temp;
                i = i / 2;
            }
        }

        public int removeMax() {
            if (count == 0) {
                return -1;
            }
            int result = a[1];
            a[1] = a[count];
            count--;
            heapify(a, count, 1);
            return result;
        }

        /**
         * 堆化-从上往下
         *
         * @param a
         * @param n
         * @param i
         */
        private void heapify(int[] a, int n, int i) {
            while (true) {
                int maxPos = i;
                if (i * 2 <= n && a[i] < a[i * 2]) {
                    maxPos = i * 2;
                }
                if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                    maxPos = i * 2 + 1;
                }
                if (maxPos == i) {
                    break;
                }
                // swap
                int temp = a[i];
                a[i] = a[maxPos];
                a[maxPos] = temp;
                i = maxPos;
            }
        }

        @Override
        public String toString() {
            return "Heap{" +
                    "a=" + Arrays.toString(a) +
                    ", n=" + n +
                    ", count=" + count +
                    '}';
        }
    }
}
