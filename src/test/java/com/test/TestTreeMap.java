package com.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class TestTreeMap {

    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null || head.next == null)
            return head;
        ListNode curr = head, nextNode = head.next;
        Map<Integer, Boolean> map = new TreeMap();
        map.put(head.val, false);
        while(nextNode != null){
            if(map.containsKey(nextNode.val)) {
                map.put(nextNode.val, true);
            } else
                 map.put(nextNode.val, false);
            nextNode = nextNode.next;
        }
        ListNode tmp = new ListNode(0);
        head = tmp;
        Iterator it =  map.keySet().iterator();
        while(it.hasNext()){
            int k = (int)it.next();
            boolean f = map.get(k);
            if(!f) {
                tmp.next = new ListNode(k);
                tmp = tmp.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Map<Integer, ListNode> map = new TreeMap<>();
        ListNode node4 = new ListNode(4,null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = deleteDuplicates(node1);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }


    }
}
