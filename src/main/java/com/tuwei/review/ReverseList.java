package com.tuwei.review;

/**
 * 反转链表
 *输入一个链表，反转链表后，输出新链表的表头
 */

public class ReverseList {

    public ListNode ReverseList(ListNode head) {

        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode node = head;
        while (node != null){
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }
}
