package com.tinytongtong.leetcodetest.test;


/**
 * 循环双端队列
 */
public class CircleDeque<E> {

    private int size;
    private int front;
    private E[] elements;
    private static final int Default_Capacity = 10;

    public CircleDeque() {
        elements = (E[]) new Object[Default_Capacity];
    }

    public int size() {
        return size;
    }

    public  boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (E element: elements) {
            element = null;
        }
        size = 0;
        front = 0;
        //缩容
        trim();
    }

    //从队尾入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[(front + size) % elements.length] = element;
        size++;
    }

    //从队头出队
    public E deQueueFront() {
        E element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    //从队头入队
    void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front -= 1;
        if (front < 0) {
            front += elements.length;
        }
        elements[front] = element;
        size++;
    }

    //从队尾出队
    public E deQueueRear() {
        int rear = (front + size - 1) % elements.length;
        E element = elements[rear];
        elements[rear] = null;
        size--;
        return element;
    }

    public E front() {
        return elements[front];
    }

    public E rear() {
        return elements[(front + size - 1) % elements.length];
    }

    //扩容
    private void ensureCapacity(int index) {
        int oldCapacity = elements.length;
        if (index <= oldCapacity) return;
        //扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        front = 0;
        elements = newElements;
    }
    //缩容
    private void trim() {
        int oldCapacity = elements.length;
        //缩容0.5倍
        int newCapacity = oldCapacity >> 1;
        if (size > newCapacity || oldCapacity >= Default_Capacity) return;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        front = 0;
        elements = newElements;
    }

    //获取对应的真实索引
    private int index(int index) {
        return 0;
    }

    public static void main(String[] args) {
        CircleDeque<Integer> queue = new CircleDeque<>();
        // 头5 4 3 2 1  100 101 102 103 104 105 106 8 7 6 尾

        // 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }
        System.out.println("当前队列为：" + queue);
        // 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
//        for (int i = 0; i < 3; i++) {
//            queue.deQueueFront();
//            queue.deQueueRear();
//        }
//
//        // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
//        queue.enQueueFront(11);
//        queue.enQueueFront(12);
//        System.out.println(queue);
//        while (!queue.isEmpty()) {
//            System.out.println(queue.deQueueFront());
//        }
    }
}
