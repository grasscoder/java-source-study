//package com.test;
//
//import java.util.*;
//
//class Node{
//    int val;
//    int weight;
//    Node(int val, int weight){
//        this.val = val;
//        this.weight = weight;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(!(obj instanceof Node)){
//            return false;
//        }
//        Node n = (Node)obj;
//       if(n.val == this.val && n.weight == this.weight)
//           return true;
//       return false;
//    }
//}
//
//public class TestBoss {
//
//    public TestBoss() {
//
//    }
//
//    static Comparator<Node> comp = new Comparator<Node>(){
//        @Override
//        public int compare(Node o1, Node o2) {
//            return o1.weight - o2.weight;
//        }
//    };
//     public int maxVal = 0;//非安全
//    static Queue<Node> queue = new PriorityQueue<>(5, comp);
//    static Map<String,Node> map = new HashMap<>();
//    public Node lruGetNode(String key) {
//        return map.get(key);
//    }
//    public int getMaxVal(Node n){
//        maxVal = maxVal > n.weight ? maxVal : 1;
//    }
//    public int lruGet(String key) {
//        Node node = map.get(key);
//        int value  = node.val;
//        queue.remove(new Node(node.val, maxVal));
//        node.weight = maxVal +1;
//        queue.add(node);
//        return value;
//    }
//
//    public void lruSet(String key, int val) {
//        maxVal = maxVal + 1;
//        Node node = new Node(val, maxVal);
//        map.put(key, node);
//        queue.remove(new Node(val,maxVal-1));
//        queue.add(node);
//    }
//
//    public static void main(String[] args) {
//        TestBoss tb = new TestBoss();
//        tb.lruSet("n1", 1);
//        tb.lruGet("n1");
//     }
//}
