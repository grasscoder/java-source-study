package com.test;

public class TestDeductList {
    public static ListNode deleteDuplicates (ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pummy = new ListNode(-1001);
        pummy.next = head;
        ListNode temp = head, pre = pummy;
        while(temp !=null && temp.next != null) {
            if(temp.val != temp.next.val) {
                pre = temp;
                temp = temp.next;
                continue;
            } else {
                ListNode p = temp.next;
                while(p.next != null && p.val == p.next.val){
                    p = p.next;
                }
                pre.next = p.next;
                temp = p.next;
            }
        }
        return pummy.next;

    }
    public static void main(String[] args) {

        ListNode n3 = new ListNode(2,null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n = new ListNode(1, n2);
        ListNode head = deleteDuplicates(n);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
