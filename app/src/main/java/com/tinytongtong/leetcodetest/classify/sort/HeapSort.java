package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;

/**
 * @Description: 堆排序
 * @Author wangjianzhou
 * @Date 2/18/22 8:10 AM
 * @Version
 */
public class HeapSort {
    public static void main(String[] args) {
        System.out.println("MaxHeap");
        MaxHeap maxHeap = new MaxHeap(6);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        System.out.println(maxHeap.toString());

        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap.toString());

        System.out.println("MinHeap");

        MinHeap minHeap = new MinHeap(6);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);
        System.out.println(minHeap.toString());

        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.removeMin());
        System.out.println(minHeap.toString());
    }

    /**
     * 大顶堆.
     * 根节点的元素最大
     */
    private static class MaxHeap {
        int[] a; // 数据容器，从下标1开始存储数据
        int n; // 堆可以存储的最大数据个数
        int count; // 堆中已经存储的数据格式

        public MaxHeap(int capacity) {
            a = new int[capacity + 1];
            n = capacity;
            count = 0;
        }

        public void insert(int data) {
            if (count > n) { // 堆满了
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
                // 分别比较左右子节点
                if (i * 2 <= n && a[i] < a[i * 2]) {
                    maxPos = i * 2;
                }
                if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                    maxPos = i * 2 + 1;
                }
                if (maxPos == i) { // 没有子节点大于父节点，退出循环
                    break;
                }
                // swap
                int temp = a[i];
                a[i] = a[maxPos];
                a[maxPos] = temp;
                // 子节点继续比较
                i = maxPos;
            }
        }

        @Override
        public String toString() {
            return "MaxHeap{" +
                    "a=" + Arrays.toString(a) +
                    ", n=" + n +
                    ", count=" + count +
                    '}';
        }
    }

    private static final class MinHeap {
        private int[] a;
        private int n;
        private int count;

        public MinHeap(int capacity) {
            a = new int[capacity + 1];
            this.n = capacity;
            count = 0;
        }

        private void insert(int data) {
            if (count > n) { // 超出范围
                return;
            }
            count++;
            a[count] = data;
            // 调整位置
            int i = count;
            while (i > 0 && i / 2 > 0 && a[i] < a[i / 2]) {
                // swap
                int tmp = a[i];
                a[i] = a[i / 2];
                a[i / 2] = tmp;
                i = i / 2;
            }
        }

        private int removeMin() {
            if (count == 0) {
                return -1;
            }
            int result = a[1];
            a[1] = a[count];
            count--;
            // heapify
            heapify(a, count, 1);
            return result;
        }

        private void heapify(int[] a, int n, int i) {
            while (true) {
                int minPos = i;
                // 比较左右子节点
                if (i * 2 <= n && a[i] > a[i * 2]) {
                    minPos = i * 2;
                }
                if (i * 2 + 1 <= n && a[i] > a[i * 2 + 1]) {
                    minPos = i * 2 + 1;
                }
                if (minPos == i) {
                    break;
                }
                // swap
                int tmp = a[i];
                a[i] = a[minPos];
                a[minPos] = tmp;
                i = minPos;
            }
        }

        @Override
        public String toString() {
            return "MinHeap{" +
                    "a=" + Arrays.toString(a) +
                    ", n=" + n +
                    ", count=" + count +
                    '}';
        }
    }
}
