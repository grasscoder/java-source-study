package com.test;
import java.util.*;
public class TestLRU {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int size = 0;

    public TestLRU(int capacity) {
        // write code here
        this.size = capacity;
        //初始化head和tail
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // write code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        // write code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (size <= 0)
                removeLast();
            else
                size--;
            putHead(node);
        }
    }

    private void moveToHead(Node node) {
        if (node.pre == head) {
            return;
        }
        Node curNodePre = node.pre;
        Node curNodeNext = node.next;
        //删除node节点
        curNodeNext.pre = curNodePre;
        curNodePre.next = curNodeNext;
        //放置于head的next节点上
        putHead(node);
    }

    private void removeLast() {
        Node node = tail.pre;
        Node preNode = node.pre;
        if (node == head) {
            return;
        }
        preNode.next = tail;
        tail.pre = preNode;
        node.pre = null;
        node.next = null;
        map.remove(node.key);
    }

    private void putHead(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.next = firstNode;
        firstNode.pre = node;
        node.pre = head;
    }

    private static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        TestLRU lru = new TestLRU(2);
        lru.set(1, 0);
        lru.set(2, 2);
        lru.get(1);
        lru.set(3, 3);
        lru.get(2);
        lru.set(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution solution = new Solution(capacity);
 * int output = solution.get(key);
 * solution.set(key,value);
 */
