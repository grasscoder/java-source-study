package com.test;

import apple.laf.JRSUIUtils;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TestNewSolution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        List<List<Integer>> list = wfsTool(n1);
//        for (List<Integer> l1 : list) {
//            for (Integer l2 : l1) {
//                System.out.println(l2);
//            }
//            System.out.println("---------");
//        }
        //前序遍历
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        preOrder(n1, l1, l2);
        System.out.println("递归前序遍历");
        l1.stream().forEach(val -> System.out.println(val));
        System.out.println("非递归前序遍历");
        l2.stream().forEach(val -> System.out.println(val));
    }

    /*
     * 广度优先搜索遍历
     * */
    public static List<List<Integer>> wfsTool(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    /*
     * 前序遍历
     */
    public static void preOrder(TreeNode root, List<Integer> list, List<Integer> list2) {
        System.out.println("-----------递归方式-----------");
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list, list2);
        preOrder(root.right, list, list2);

//        System.out.println("-----------非递归方式---------");
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            if (root != null) {
//                list2.add(root.val);
//                stack.push(root);
//                root = root.left;
//            } else {
//                root = stack.pop();
//                root = root.right;
//            }
//        }
    }
    public void midOrder(TreeNode root, List<Integer> list){
        if(root == null){
;
        }
    }


}
