package com.test;

public class TestReverseBetween {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode head = new ListNode(3, n1);
        ListNode l = reverseBetween(head, 1, 2);
        for(;l != null; l = l.next){
            System.out.println(l.val);
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode tmpLeft = new ListNode(-10000);
        int i = 1;
        while(cur != null && i != left){
            tmpLeft = cur;
            cur = cur.next;
            i++;
        }
        ListNode n = reverse(cur, right - left + 1);
        if(i == 1)
            head = n;
        else
            tmpLeft.next = n;
        return head;
    }
    public static ListNode reverse(ListNode head, int n){//翻转链表的前n个节点
        if(head == null || head.next == null || n <= 1)
            return head;
        ListNode pre = null, cur = head;
        int i = 0;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
            if(i == n){
                break;
            }
        }
        head.next = cur;
        return pre;
    }
}
