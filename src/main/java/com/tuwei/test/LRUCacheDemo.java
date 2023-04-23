package com.tuwei.test;

import java.util.HashMap;

public class LRUCacheDemo {

    class LinkNode{
        int key;
        int value;
        LinkNode pre;
        LinkNode next;
        public LinkNode(){};
        public LinkNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer,LinkNode> hm = new HashMap<>();
    private Integer size;
    private Integer capacity;
    private LinkNode head;
    private LinkNode tail;

    public LRUCacheDemo(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        LinkNode node = hm.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        LinkNode node = hm.get(key);
        if(node == null){
            LinkNode linkNode = new LinkNode(key,value);
            hm.put(key,node);
            addNodeToHead(node);
            size++;
            if(size > capacity){
                LinkNode tail = deleteTailNode();
                hm.remove(tail.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }

    }

    public void addNodeToHead(LinkNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void deleteNode(LinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(LinkNode node){
        addNodeToHead(node);
        deleteNode(node);
    }

    public LinkNode deleteTailNode(){
        LinkNode res = tail.pre;
        deleteNode(res);
        return res;
    }

}
