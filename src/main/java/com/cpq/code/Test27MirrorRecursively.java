package com.cpq.code;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题27：二叉树的镜像
// 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。

import com.cpq.code.util.BinaryTreeNode;

import java.util.Stack;

public class Test27MirrorRecursively {
 
    // 递归实现
    public void MirrorRecursively(BinaryTreeNode root){
        if (root == null)
            return ;
        

        if (root.m_pLeft == null && root.m_pRight == null)
            return;
        BinaryTreeNode temp = root.m_pLeft;
        root.m_pLeft = root.m_pRight;
        root.m_pRight = temp;

        if (root.m_pLeft != null)
            MirrorRecursively(root.m_pLeft);
        if (root.m_pRight != null)
            MirrorRecursively(root.m_pRight);

    }

    void MirrorIteratively(BinaryTreeNode pRoot)
    {
        if(pRoot == null)
            return;
         Stack<BinaryTreeNode> stackTreeNode = new Stack<>();
        stackTreeNode.push(pRoot);
//        std::stack<BinaryTreeNode*> stackTreeNode;
//        stackTreeNode.push(pRoot);

        while(stackTreeNode.size() > 0)
        {
            BinaryTreeNode pNode = stackTreeNode.peek();
            stackTreeNode.pop();

            BinaryTreeNode pTemp = pNode.m_pLeft;
            pNode.m_pLeft = pNode.m_pRight;
            pNode.m_pRight = pTemp;

            if(pNode.m_pLeft != null)
                stackTreeNode.push(pNode.m_pLeft);

            if(pNode.m_pRight != null)
                stackTreeNode.push(pNode.m_pRight);
        }
    }

    // ====================测试代码====================
// 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
//            8
//        6      10
//       5 7    9  11
    void Test1()
    {
        System.out.printf("=====Test1 starts:=====\n");
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);
        BinaryTreeNode pNode6 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode10 = BinaryTreeNode.CreateBinaryTreeNode(10);
        BinaryTreeNode pNode5 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode7 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode9 = BinaryTreeNode.CreateBinaryTreeNode(9);
        BinaryTreeNode pNode11 = BinaryTreeNode.CreateBinaryTreeNode(11);

        BinaryTreeNode.ConnectTreeNodes(pNode8, pNode6, pNode10);
        BinaryTreeNode.ConnectTreeNodes(pNode6, pNode5, pNode7);
        BinaryTreeNode.ConnectTreeNodes(pNode10, pNode9, pNode11);

        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test1: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test1: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        BinaryTreeNode.DestroyTree(pNode8);
    }

    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
//            8
//          7   
//        6 
//      5
//    4
    void Test2()
    {
        System.out.printf("=====Test2 starts:=====\n");
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);
        BinaryTreeNode pNode7 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode6 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode5 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode4 = BinaryTreeNode.CreateBinaryTreeNode(4);

        BinaryTreeNode.ConnectTreeNodes(pNode8, pNode7, null);
        BinaryTreeNode.ConnectTreeNodes(pNode7, pNode6, null);
        BinaryTreeNode.ConnectTreeNodes(pNode6, pNode5, null);
        BinaryTreeNode.ConnectTreeNodes(pNode5, pNode4, null);

        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test2: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test2: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        BinaryTreeNode.DestroyTree(pNode8);
    }

    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
//            8
//             7   
//              6 
//               5
//                4
    void Test3()
    {
        System.out.printf("=====Test3 starts:=====\n");
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);
        BinaryTreeNode pNode7 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode6 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode5 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode4 = BinaryTreeNode.CreateBinaryTreeNode(4);

        BinaryTreeNode.ConnectTreeNodes(pNode8, null, pNode7);
        BinaryTreeNode.ConnectTreeNodes(pNode7, null, pNode6);
        BinaryTreeNode.ConnectTreeNodes(pNode6, null, pNode5);
        BinaryTreeNode.ConnectTreeNodes(pNode5, null, pNode4);

        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test3: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test3: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        BinaryTreeNode.DestroyTree(pNode8);
    }

    // 测试空二叉树：根结点为空指针
    void Test4()
    {
        System.out.printf("=====Test4 starts:=====\n");
        BinaryTreeNode pNode = null;

        BinaryTreeNode.PrintTree(pNode);

        System.out.printf("=====Test4: MirrorRecursively=====\n");
        MirrorRecursively(pNode);
        BinaryTreeNode.PrintTree(pNode);

        System.out.printf("=====Test4: MirrorIteratively=====\n");
        MirrorIteratively(pNode);
        BinaryTreeNode.PrintTree(pNode);
    }

    // 测试只有一个结点的二叉树
    void Test5()
    {
        System.out.printf("=====Test5 starts:=====\n");
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);

        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test4: MirrorRecursively=====\n");
        MirrorRecursively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);

        System.out.printf("=====Test4: MirrorIteratively=====\n");
        MirrorIteratively(pNode8);
        BinaryTreeNode.PrintTree(pNode8);
    }

    public static void main(String[] args) {
        final Test27MirrorRecursively test27MirrorRecursively = new Test27MirrorRecursively();
        test27MirrorRecursively.Test1();
        test27MirrorRecursively.Test2();
        test27MirrorRecursively.Test3();
        test27MirrorRecursively.Test4();
        test27MirrorRecursively.Test5();
    }
    
}
