package com.cpq.code.util;

import java.security.PublicKey;

public class BinaryTreeNode {

    public int m_dbValue;
    public BinaryTreeNode m_pLeft;
    public BinaryTreeNode m_pRight;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.m_dbValue = value;
    }

    // ====================辅助测试代码====================
    public static BinaryTreeNode CreateBinaryTreeNode(int dbValue) {
        BinaryTreeNode pNode = new BinaryTreeNode();
        pNode.m_dbValue = dbValue;
        pNode.m_pLeft = null;
        pNode.m_pRight = null;

        return pNode;
    }

    public static void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
        if (pParent != null) {
            pParent.m_pLeft = pLeft;
            pParent.m_pRight = pRight;
        }
    }

    public static void DestroyTree(BinaryTreeNode pRoot) {
        if (pRoot != null) {
            BinaryTreeNode pLeft = pRoot.m_pLeft;
            BinaryTreeNode pRight = pRoot.m_pRight;

            DestroyTree(pLeft);
            DestroyTree(pRight);
        }
    }

    public static void PrintTree(BinaryTreeNode pRoot) {
        PrintTreeNode(pRoot);

        if (pRoot != null) {
            if (pRoot.m_pLeft != null)
                PrintTree(pRoot.m_pLeft);

            if (pRoot.m_pRight != null)
                PrintTree(pRoot.m_pRight);
        }
    }

    public static void PrintTreeNode(BinaryTreeNode pNode) {
        if (pNode != null) {
            System.out.printf("value of this node is: %d\n", pNode.m_dbValue);

            if (pNode.m_pLeft != null)
                System.out.printf("value of its left child is: %d.\n", pNode.m_pLeft.m_dbValue);
            else
                System.out.printf("left child is null.\n");

            if (pNode.m_pRight != null)
                System.out.printf("value of its right child is: %d.\n", pNode.m_pRight.m_dbValue);
            else
                System.out.printf("right child is null.\n");
        } else {
            System.out.printf("this node is null.\n");
        }

        System.out.printf("\n");
    }

    public static BinaryTreeNode[] getBinaryTreeNodes (){
        BinaryTreeNode[] nodes = {test1(),test2(),test3(),test4(),test5()};
        return nodes;
    }
    //null
    private static BinaryTreeNode test1() {
        BinaryTreeNode node = null;
        return node;
    }

    //单个结点
    private static BinaryTreeNode test2() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        return node;
    }

    //左斜
    private static BinaryTreeNode test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node1.m_pLeft = node2;
        node2.m_pLeft = node3;
        return node1;
    }

    //右斜
    private static BinaryTreeNode test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node1.m_pRight = node2;
        node2.m_pRight = node3;
        return node1;
    }

    //完全二叉树
    /**
     *                1
     *       2               3
     *   4      5        6        7
     * 8  9  10  11   12   13   14 15
     *
     */
    private static BinaryTreeNode test5() {
        BinaryTreeNode[] nodes = new BinaryTreeNode[15];
        for (int i = 0; i < 15; i++) {
            nodes[i] = new BinaryTreeNode(i + 1);
        }
        for (int i = 0; i < 7; i++) {
            nodes[i].m_pLeft = nodes[2 * i + 1];
            nodes[i].m_pRight = nodes[2 * i + 2];
        }
        return nodes[0];
    }
//    2）非递归实现，有了上面前序的解释，中序也就比較简单了。同样的道理。仅仅只是訪问的顺序移到出栈时。代码例如以下
    //中序遍历的非递归的写法，
    // 1.左节点不为null则压入左节点
    // 2.左节点为null时，pop并打印，左节点
    // 3.在往右，右节点为null时，pop并打印
    // 4.右节点不为null时，压入右节点
    //还是背下来吧

//    https://blog.csdn.net/qq_37859539/article/details/81462171


}
