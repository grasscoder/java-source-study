package com.test;

import java.util.ArrayList;

public class TestLastNodes {
    public static ListNode findKthToTail (ListNode head, int k) {
        // write code here
        if(head == null || (head.next == null && k > 1))
            return head;
        if(head.next == null && k == 1)
            return head;
        if(k <= 0)
            return null;
        ListNode pre = head;
        ListNode after = head;
        for(int i = 0; i < k; i++){
            after = after.next;
            if(after == null && i==(k-1)) {
                return head;
            }
            if(after == null && i< (k-1) )
                return null;
        }

        while(after != null){
            after = after.next;
            pre = pre.next;
        }
        return pre;

    }
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5,null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(0, n2);
        ListNode head = findKthToTail(n1,5);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
