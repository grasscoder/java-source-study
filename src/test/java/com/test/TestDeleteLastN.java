package com.test;

import java.util.List;

public class TestDeleteLastN {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) return null;
        if (n <= 0) return null;
        ListNode pre = head, after = head, temp = head;
        int m = 0;
        for (int i = 1; (m = i) < n; i++) {
            after = after.next;
        }
        if (after == null)
            return head;
        if (after.next == null) {
            if (n == m)
                return head.next;
            return after;
        }
        //if(after == head) return null;
        while (after.next != null) {
            after = after.next;
            temp = pre;
            pre = pre.next;
        }
        temp.next = pre.next;
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode head = removeNthFromEnd(node, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
