package com.tuwei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU,最近最少使用
 */

public class LRUCache {

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

    class DLinkedNode{
        private Integer key;
        private Integer value;
        private DLinkedNode pre;
        private DLinkedNode next;
        public DLinkedNode(){}
        private DLinkedNode(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head;
    private DLinkedNode tail;
    private Integer capacity;
    private Integer size;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    //删除一个中间结点
    public void deleteNode(DLinkedNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    //头节点插入
    public void addHeadNode(DLinkedNode node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    //删除尾节点
    public DLinkedNode deleteTail(){
        DLinkedNode node = tail.pre;
        deleteNode(node);
        return node;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node != null){
            node.value = value;
            deleteNode(node);
            addHeadNode(node);
        }else{
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            addHeadNode(newNode);
            size++;
            if(size>capacity){
                DLinkedNode tailNode = deleteTail();
                cache.remove(tailNode.key);
                size--;
            }
        }
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            deleteNode(node);
            addHeadNode(node);
            return node.value;
        }
    }
}
