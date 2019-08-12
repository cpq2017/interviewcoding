package com.cpq.code;
// 面试题32
//（一）从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。广度优先遍历
//（二）从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
//（三）请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

import com.cpq.code.util.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test32PrintBinaryTree {
    //BFS 广度优先遍历
    public void PrintFromTopToBottom(BinaryTreeNode root) {
        if (root == null)
            return;
        final LinkedList<BinaryTreeNode> queue = new LinkedList<>();
//        queue.offer(root);
        queue.add(root);
        BinaryTreeNode node = null;
        while (queue.size() != 0) {
            node = queue.remove();
//            node = queue.poll();
            System.out.print(node.m_dbValue + " ");
            if (node.m_pLeft != null)
//            queue.offer(node.m_pLeft);
                queue.add(node.m_pLeft);
            if (node.m_pRight != null)
//            queue.offer(node.m_pRight);
                queue.add(node.m_pRight);
        }
        System.out.println();
    }

    public void Print2(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        int nextLevel = 0;       //下一层结点数目
        int toBeprinted = 1;     //当前层结点数目
        BinaryTreeNode node = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(node.m_dbValue + " ");
            if (node.m_pLeft != null) {
                queue.add(node.m_pLeft);
                ++nextLevel;
            }
            if (node.m_pRight != null) {
                queue.add(node.m_pRight);
                ++nextLevel;
            }
            --toBeprinted;
            if (toBeprinted == 0) {
                System.out.println();
                toBeprinted = nextLevel;
                nextLevel = 0;
            }

        }

    }

    public void printTree3_2(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        BinaryTreeNode node = null;
        while (!stack1.empty() || !stack2.empty()) {
            while (!stack1.empty()) {
                node = stack1.pop();
                System.out.print(node.m_dbValue+" ");
                if (node.m_pLeft != null)
                    stack2.push(node.m_pLeft);
                if (node.m_pRight != null)
                    stack2.push(node.m_pRight);

            }
            System.out.println();

            while (!stack2.empty()) {
                node = stack2.pop();
                 System.out.print( node.m_dbValue+" ");
                if (node.m_pRight != null)
                    stack1.push(node.m_pRight);
                if (node.m_pLeft != null)
                    stack1.push(node.m_pLeft);

            }
            System.out.println();
        }
    }

    //============测试代码==============
    private void test(int testNum, BinaryTreeNode root) {
        System.out.println("=========test" + testNum + "===========");
//        System.out.println("method1: Tree");
//        BinaryTreeNode.PrintTree(root);
//        System.out.println("method1: PrintFromTopToBottom");
//        PrintFromTopToBottom(root);
        System.out.println("method2:method2");
        Print2(root);
//        System.out.println("method3_1:");
//        printTree3_1(root);
        System.out.println("method3_2:");
        printTree3_2(root);
    }

    //null
    private void test1() {
        BinaryTreeNode node = null;
        test(1, node);
    }

    //单个结点
    private void test2() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        test(2, node);
    }

    //左斜
    private void test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node1.m_pLeft = node2;
        node2.m_pLeft = node3;
        test(3, node1);
    }

    //右斜
    private void test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node1.m_pRight = node2;
        node2.m_pRight = node3;
        test(4, node1);
    }

    //完全二叉树
    private void test5() {
        BinaryTreeNode[] nodes = new BinaryTreeNode[15];
        for (int i = 0; i < 15; i++) {
            nodes[i] = new BinaryTreeNode(i + 1);
        }
        for (int i = 0; i < 7; i++) {
            nodes[i].m_pLeft = nodes[2 * i + 1];
            nodes[i].m_pRight = nodes[2 * i + 2];
        }
        test(5, nodes[0]);
    }

    public static void main(String[] args) {
        final Test32PrintBinaryTree test32 = new Test32PrintBinaryTree();
        test32.test1();
        test32.test2();
        test32.test3();
        test32.test4();
        test32.test5();

    }
}
