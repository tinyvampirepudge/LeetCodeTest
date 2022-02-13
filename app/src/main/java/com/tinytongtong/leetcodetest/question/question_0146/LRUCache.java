package com.tinytongtong.leetcodetest.question.question_0146;

import java.util.HashMap;

/**
 * @Description: 146. LRU 缓存
 * https://leetcode-cn.com/problems/lru-cache/
 * @Author wangjianzhou
 * @Date 2022/2/10 4:46 PM
 */
public class LRUCache {

//    public LRUCache(int capacity) {
//
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }

    int capacity = 0;
    int size = 0;// 数据容量
    // 双向链表，头节点和尾结点。最新使用的在头节点。
    LinkNode head = null, tail = null;
    // 数据容器
    HashMap<Integer, LinkNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkNode node = cache.get(key);
        if (node == null) {
            // 添加新节点
            LinkNode newNode = new LinkNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            // 超出容量后，移除尾部
            if (size > capacity) {
                LinkNode r = removeTail();
                cache.remove(r.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LinkNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private LinkNode removeTail(){
        LinkNode result = tail.prev;
        removeNode(result);
        return result;
    }

    private static final class LinkNode {
        int key, value;
        LinkNode prev, next;

        public LinkNode() {

        }

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
