package com.test;

public class TestReverseForTwo {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        //prev是新new的节点,其next指向了head，从prev后面的两个节点开始两两交换
        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next; // 将 prev 的 next 改为 head 的 next
            head.next.next = head; // 将 head.next(prev.next) 的next，指向 head
            head.next = temp; // 将head 的 next 接上缓存的temp

            prev = head; // 步进1位
            head = temp;// 步进1位
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = swapPairs(n1);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
