package com.cpq.code;

import java.util.Stack;

public class Test6PrintLink {
    static class ListNode {
        int val;
        ListNode nxt;
    }

    /**
     * 使用栈实现从尾部遍历
     * @param root
     */
    public static void printlink(ListNode root){
        Stack<ListNode> nodes = new Stack<>();
        while (root != null) {
            nodes.push(root);
            root = root.nxt;
        }
        while (!nodes.empty()){
            System.out.print(nodes.pop().val +" ");
        }


    }

    /**
     * 使用递归方式，存在调用栈溢出情况
     * @param root
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            System.out.print(root.val + " ");
        }
    }


    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.nxt = new ListNode();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.val = 4;
        root.nxt.nxt.nxt.nxt = new ListNode();
        root.nxt.nxt.nxt.nxt.val = 5;
        printlink(root);
//        printListInverselyUsingIteration(root);
        System.out.println();
        printListInverselyUsingRecursion(root);
    }
}
