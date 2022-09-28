package com.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestSortList {

    public static ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null) {
            return head;
        }
        Comparator comp = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        ListNode node = head;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(comp);
        while(node != null) {
            queue.add(node);
            node = node.next;
        }
        ListNode ns = new ListNode(-1);
        head = ns;
        while(!queue.isEmpty()) {
            ns.next = queue.poll();
            ns = ns.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5,null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = sortInList(n1);


        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
