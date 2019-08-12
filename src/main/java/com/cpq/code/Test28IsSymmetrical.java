package com.cpq.code;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题28：对称的二叉树
// 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
// 它的镜像一样，那么它是对称的。

import com.cpq.code.util.BinaryTreeNode;

public class Test28IsSymmetrical {
    public boolean isSymmetrical(BinaryTreeNode root){
        return issymmetrical(root,root);
    }
    public boolean issymmetrical(BinaryTreeNode aroot,BinaryTreeNode broot){
        if (aroot == null && broot == null)
            return true;
        if (aroot == null || broot == null)
            return false;
        if (aroot.m_dbValue != broot.m_dbValue)
            return false;
        return issymmetrical(aroot.m_pLeft,broot.m_pRight) &&
                issymmetrical(aroot.m_pRight,broot.m_pLeft);
    }
    
    // ====================测试代码====================
    void Test(String testName, BinaryTreeNode pRoot, boolean expected)
    {
        if(testName != null)
            System.out.printf("%s begins: ", testName);

        if(isSymmetrical(pRoot) == expected)
            System.out.printf("result =" +expected + ",Passed.\n");
        else
            System.out. printf("result =" +isSymmetrical(pRoot) +",FAILED.\n");
    }

//            8
//        6      6
//       5 7    7 5
    void Test1()
    {
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);
        BinaryTreeNode pNode61 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode62 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode51 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode71 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode72 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode52 = BinaryTreeNode.CreateBinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNodes(pNode8, pNode61, pNode62);
        BinaryTreeNode.ConnectTreeNodes(pNode61, pNode51, pNode71);
        BinaryTreeNode.ConnectTreeNodes(pNode62, pNode72, pNode52);

        Test("Test1", pNode8, true);

        BinaryTreeNode.DestroyTree(pNode8);
    }

//            8
//        6      9
//       5 7    7 5
    void Test2()
    {
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);
        BinaryTreeNode pNode61 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode9 = BinaryTreeNode.CreateBinaryTreeNode(9);
        BinaryTreeNode pNode51 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode71 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode72 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode52 = BinaryTreeNode.CreateBinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNodes(pNode8, pNode61, pNode9);
        BinaryTreeNode.ConnectTreeNodes(pNode61, pNode51, pNode71);
        BinaryTreeNode.ConnectTreeNodes(pNode9, pNode72, pNode52);

        Test("Test2", pNode8, false);

        BinaryTreeNode.DestroyTree(pNode8);
    }

//            8
//        6      6
//       5 7    7
    void Test3()
    {
        BinaryTreeNode pNode8 = BinaryTreeNode.CreateBinaryTreeNode(8);
        BinaryTreeNode pNode61 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode62 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode51 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode71 = BinaryTreeNode.CreateBinaryTreeNode(7);
        BinaryTreeNode pNode72 = BinaryTreeNode.CreateBinaryTreeNode(7);

        BinaryTreeNode.ConnectTreeNodes(pNode8, pNode61, pNode62);
        BinaryTreeNode.ConnectTreeNodes(pNode61, pNode51, pNode71);
        BinaryTreeNode.ConnectTreeNodes(pNode62, pNode72, null);

        Test("Test3", pNode8, false);

        BinaryTreeNode.DestroyTree(pNode8);
    }

//               5
//              / \
//             3   3
//            /     \
//           4       4
//          /         \
//         2           2
//        /             \
//       1               1
    void Test4()
    {
        BinaryTreeNode pNode5 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode31 = BinaryTreeNode.CreateBinaryTreeNode(3);
        BinaryTreeNode pNode32 = BinaryTreeNode.CreateBinaryTreeNode(3);
        BinaryTreeNode pNode41 = BinaryTreeNode.CreateBinaryTreeNode(4);
        BinaryTreeNode pNode42 = BinaryTreeNode.CreateBinaryTreeNode(4);
        BinaryTreeNode pNode21 = BinaryTreeNode.CreateBinaryTreeNode(2);
        BinaryTreeNode pNode22 = BinaryTreeNode.CreateBinaryTreeNode(2);
        BinaryTreeNode pNode11 = BinaryTreeNode.CreateBinaryTreeNode(1);
        BinaryTreeNode pNode12 = BinaryTreeNode.CreateBinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNodes(pNode5, pNode31, pNode32);
        BinaryTreeNode.ConnectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNodes(pNode41, pNode21, null);
        BinaryTreeNode.ConnectTreeNodes(pNode42, null, pNode22);
        BinaryTreeNode.ConnectTreeNodes(pNode21, pNode11, null);
        BinaryTreeNode.ConnectTreeNodes(pNode22, null, pNode12);

        Test("Test4", pNode5, true);

        BinaryTreeNode.DestroyTree(pNode5);
    }


//               5
//              / \
//             3   3
//            /     \
//           4       4
//          /         \
//         6           2
//        /             \
//       1               1
    void Test5()
    {
        BinaryTreeNode pNode5 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode31 = BinaryTreeNode.CreateBinaryTreeNode(3);
        BinaryTreeNode pNode32 = BinaryTreeNode.CreateBinaryTreeNode(3);
        BinaryTreeNode pNode41 = BinaryTreeNode.CreateBinaryTreeNode(4);
        BinaryTreeNode pNode42 = BinaryTreeNode.CreateBinaryTreeNode(4);
        BinaryTreeNode pNode6 = BinaryTreeNode.CreateBinaryTreeNode(6);
        BinaryTreeNode pNode22 = BinaryTreeNode.CreateBinaryTreeNode(2);
        BinaryTreeNode pNode11 = BinaryTreeNode.CreateBinaryTreeNode(1);
        BinaryTreeNode pNode12 = BinaryTreeNode.CreateBinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNodes(pNode5, pNode31, pNode32);
        BinaryTreeNode.ConnectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNodes(pNode41, pNode6, null);
        BinaryTreeNode.ConnectTreeNodes(pNode42, null, pNode22);
        BinaryTreeNode.ConnectTreeNodes(pNode6, pNode11, null);
        BinaryTreeNode.ConnectTreeNodes(pNode22, null, pNode12);

        Test("Test5", pNode5, false);

        BinaryTreeNode.DestroyTree(pNode5);
    }

//               5
//              / \
//             3   3
//            /     \
//           4       4
//          /         \
//         2           2
//                      \
//                       1
    void Test6()
    {
        BinaryTreeNode pNode5 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode31 = BinaryTreeNode.CreateBinaryTreeNode(3);
        BinaryTreeNode pNode32 = BinaryTreeNode.CreateBinaryTreeNode(3);
        BinaryTreeNode pNode41 = BinaryTreeNode.CreateBinaryTreeNode(4);
        BinaryTreeNode pNode42 = BinaryTreeNode.CreateBinaryTreeNode(4);
        BinaryTreeNode pNode21 = BinaryTreeNode.CreateBinaryTreeNode(2);
        BinaryTreeNode pNode22 = BinaryTreeNode.CreateBinaryTreeNode(2);
        BinaryTreeNode pNode12 = BinaryTreeNode.CreateBinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNodes(pNode5, pNode31, pNode32);
        BinaryTreeNode.ConnectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNodes(pNode41, pNode21, null);
        BinaryTreeNode.ConnectTreeNodes(pNode42, null, pNode22);
        BinaryTreeNode.ConnectTreeNodes(pNode21, null, null);
        BinaryTreeNode.ConnectTreeNodes(pNode22, null, pNode12);

        Test("Test6", pNode5, false);

        BinaryTreeNode.DestroyTree(pNode5);
    }

    // 只有一个结点
    void Test7()
    {
        BinaryTreeNode pNode1 = BinaryTreeNode.CreateBinaryTreeNode(1);
        Test("Test7", pNode1, true);

        BinaryTreeNode.DestroyTree(pNode1);
    }

    // 没有结点
    void Test8()
    {
        Test("Test8", null, true);
    }

// 所有结点都有相同的值，树对称
//               5
//              / \
//             5   5
//            /     \
//           5       5
//          /         \
//         5           5
    void Test9()
    {
        BinaryTreeNode pNode1 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode21 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode22 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode31 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode32 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode41 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode42 = BinaryTreeNode.CreateBinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNodes(pNode1, pNode21, pNode22);
        BinaryTreeNode.ConnectTreeNodes(pNode21, pNode31, null);
        BinaryTreeNode.ConnectTreeNodes(pNode22, null, pNode32);
        BinaryTreeNode.ConnectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNodes(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNodes(pNode41, null, null);
        BinaryTreeNode.ConnectTreeNodes(pNode42, null, null);

        Test("Test9", pNode1, true);

        BinaryTreeNode.DestroyTree(pNode1);
    }

// 所有结点都有相同的值，树不对称
//               5
//              / \
//             5   5
//            /     \
//           5       5
//          /       /
//         5       5
    void Test10()
    {
        BinaryTreeNode pNode1 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode21 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode22 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode31 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode32 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode41 = BinaryTreeNode.CreateBinaryTreeNode(5);
        BinaryTreeNode pNode42 = BinaryTreeNode.CreateBinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNodes(pNode1, pNode21, pNode22);
        BinaryTreeNode.ConnectTreeNodes(pNode21, pNode31, null);
        BinaryTreeNode.ConnectTreeNodes(pNode22, null, pNode32);
        BinaryTreeNode.ConnectTreeNodes(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNodes(pNode32, pNode42, null);
        BinaryTreeNode.ConnectTreeNodes(pNode41, null, null);
        BinaryTreeNode.ConnectTreeNodes(pNode42, null, null);

        Test("Test10", pNode1, false);

        BinaryTreeNode.DestroyTree(pNode1);
    }

    public static void main(String[] args) {
        final Test28IsSymmetrical test28IsSymmetrical = new Test28IsSymmetrical();
        test28IsSymmetrical.Test1();
        test28IsSymmetrical.Test2();
        test28IsSymmetrical.Test3();
        test28IsSymmetrical.Test4();
        test28IsSymmetrical.Test5();
        test28IsSymmetrical.Test6();
        test28IsSymmetrical.Test7();
        test28IsSymmetrical.Test8();
        test28IsSymmetrical.Test9();
        test28IsSymmetrical.Test10();




    }
}
