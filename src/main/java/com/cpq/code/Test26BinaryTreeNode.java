package com.cpq.code;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题26：树的子结构
// 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
public class Test26BinaryTreeNode {
    class BinaryTreeNode {
        double m_dbValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
    }

    public boolean HasSubtree(BinaryTreeNode aroot, BinaryTreeNode broot) {
        boolean flag = false;
        if (aroot != null && broot != null) {
            //检测root节点是否相等
            if (Equal(aroot.m_dbValue, broot.m_dbValue)){
                //相等检查root的子节点
                flag = DoesTree1HaveTree2(aroot,broot);
            }
            if (!flag)
                flag = HasSubtree(aroot.m_pLeft,broot);
            if (!flag)
                flag = HasSubtree(aroot.m_pRight,broot);
        }

        return flag;
    }

    private boolean Equal(double a, double b) {
        if ((a - b > -0.0000001) && (a - b) < 0.000000001)
            return true;
        else
            return false;
    }
    private boolean DoesTree1HaveTree2(BinaryTreeNode aroot,BinaryTreeNode broot){
        if (broot == null)
            return true;
        if (aroot == null)
            return false;
        if (!Equal(aroot.m_dbValue,broot.m_dbValue))
            return false;
        return DoesTree1HaveTree2(aroot.m_pLeft,broot.m_pLeft) && DoesTree1HaveTree2(aroot.m_pRight ,broot.m_pRight);
    }


    // ====================辅助测试代码====================
    BinaryTreeNode CreateBinaryTreeNode(double dbValue)
    {
        BinaryTreeNode pNode = new BinaryTreeNode();
        pNode.m_dbValue = dbValue;
        pNode.m_pLeft = null;
        pNode.m_pRight = null;

        return pNode;
    }

    void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight)
    {
        if(pParent != null)
        {
            pParent.m_pLeft = pLeft;
            pParent.m_pRight = pRight;
        }
    }

    void DestroyTree(BinaryTreeNode pRoot)
    {
        if(pRoot != null)
        {
            BinaryTreeNode pLeft = pRoot.m_pLeft;
            BinaryTreeNode pRight = pRoot.m_pRight;

            DestroyTree(pLeft);
            DestroyTree(pRight);
        }
    }

    // ====================测试代码====================
    void Test(String testName, BinaryTreeNode pRoot1, BinaryTreeNode pRoot2, boolean expected)
    {
        if(HasSubtree(pRoot1, pRoot2) == expected)
            System.out.printf("%s passed.\n", testName);
        else
            System.out.printf("%s failed.\n", testName);
    }

    // 树中结点含有分叉，树B是树A的子结构
//                  8                8
//              /       \           / \
//             8         7         9   2
//           /   \
//          9     2
//               / \
//              4   7
    void Test1()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(7);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(2);
        BinaryTreeNode pNodeA6 = CreateBinaryTreeNode(4);
        BinaryTreeNode pNodeA7 = CreateBinaryTreeNode(7);

        ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
        ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

        Test("Test1", pNodeA1, pNodeB1, true);

        DestroyTree(pNodeA1);
        DestroyTree(pNodeB1);
    }

    // 树中结点含有分叉，树B不是树A的子结构
//                  8                8
//              /       \           / \
//             8         7         9   2
//           /   \
//          9     3
//               / \
//              4   7
    void Test2()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(7);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(3);
        BinaryTreeNode pNodeA6 = CreateBinaryTreeNode(4);
        BinaryTreeNode pNodeA7 = CreateBinaryTreeNode(7);

        ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
        ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
        ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

        Test("Test2", pNodeA1, pNodeB1, false);

        DestroyTree(pNodeA1);
        DestroyTree(pNodeB1);
    }

    // 树中结点只有左子结点，树B是树A的子结构
//                8                  8
//              /                   /
//             8                   9
//           /                    /
//          9                    2
//         /
//        2
//       /
//      5
    void Test3()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

        ConnectTreeNodes(pNodeA1, pNodeA2, null);
        ConnectTreeNodes(pNodeA2, pNodeA3, null);
        ConnectTreeNodes(pNodeA3, pNodeA4, null);
        ConnectTreeNodes(pNodeA4, pNodeA5, null);

        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeB1, pNodeB2, null);
        ConnectTreeNodes(pNodeB2, pNodeB3, null);

        Test("Test3", pNodeA1, pNodeB1, true);

        DestroyTree(pNodeA1);
        DestroyTree(pNodeB1);
    }

    // 树中结点只有左子结点，树B不是树A的子结构
//                8                  8
//              /                   /
//             8                   9
//           /                    /
//          9                    3
//         /
//        2
//       /
//      5
    void Test4()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

        ConnectTreeNodes(pNodeA1, pNodeA2, null);
        ConnectTreeNodes(pNodeA2, pNodeA3, null);
        ConnectTreeNodes(pNodeA3, pNodeA4, null);
        ConnectTreeNodes(pNodeA4, pNodeA5, null);

        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(3);

        ConnectTreeNodes(pNodeB1, pNodeB2, null);
        ConnectTreeNodes(pNodeB2, pNodeB3, null);

        Test("Test4", pNodeA1, pNodeB1, false);

        DestroyTree(pNodeA1);
        DestroyTree(pNodeB1);
    }

    // 树中结点只有右子结点，树B是树A的子结构
//       8                   8
//        \                   \
//         8                   9
//          \                   \
//           9                   2
//            \
//             2
//              \
//               5
    void Test5()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

        ConnectTreeNodes(pNodeA1, null, pNodeA2);
        ConnectTreeNodes(pNodeA2, null, pNodeA3);
        ConnectTreeNodes(pNodeA3, null, pNodeA4);
        ConnectTreeNodes(pNodeA4, null, pNodeA5);

        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeB1, null, pNodeB2);
        ConnectTreeNodes(pNodeB2, null, pNodeB3);

        Test("Test5", pNodeA1, pNodeB1, true);

        DestroyTree(pNodeA1);
        DestroyTree(pNodeB1);
    }

    // 树A中结点只有右子结点，树B不是树A的子结构
//       8                   8
//        \                   \
//         8                   9
//          \                 / \
//           9               3   2
//            \
//             2
//              \
//               5
    void Test6()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);
        BinaryTreeNode pNodeA5 = CreateBinaryTreeNode(5);

        ConnectTreeNodes(pNodeA1, null, pNodeA2);
        ConnectTreeNodes(pNodeA2, null, pNodeA3);
        ConnectTreeNodes(pNodeA3, null, pNodeA4);
        ConnectTreeNodes(pNodeA4, null, pNodeA5);

        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(3);
        BinaryTreeNode pNodeB4 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeB1, null, pNodeB2);
        ConnectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

        Test("Test6", pNodeA1, pNodeB1, false);

        DestroyTree(pNodeA1);
        DestroyTree(pNodeB1);
    }

    // 树A为空树
    void Test7()
    {
        BinaryTreeNode pNodeB1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeB2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeB3 = CreateBinaryTreeNode(3);
        BinaryTreeNode pNodeB4 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeB1, null, pNodeB2);
        ConnectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

        Test("Test7", null, pNodeB1, false);

        DestroyTree(pNodeB1);
    }

    // 树B为空树
    void Test8()
    {
        BinaryTreeNode pNodeA1 = CreateBinaryTreeNode(8);
        BinaryTreeNode pNodeA2 = CreateBinaryTreeNode(9);
        BinaryTreeNode pNodeA3 = CreateBinaryTreeNode(3);
        BinaryTreeNode pNodeA4 = CreateBinaryTreeNode(2);

        ConnectTreeNodes(pNodeA1, null, pNodeA2);
        ConnectTreeNodes(pNodeA2, pNodeA3, pNodeA4);

        Test("Test8", pNodeA1, null, false);

        DestroyTree(pNodeA1);
    }

    // 树A和树B都为空
    void Test9()
    {
        Test("Test9", null, null, false);
    }

    public static void main(String[] args) {
        final Test26BinaryTreeNode test26BinaryTreeNode = new Test26BinaryTreeNode();
        test26BinaryTreeNode.Test1();
        test26BinaryTreeNode.Test2();
        test26BinaryTreeNode.Test3();
        test26BinaryTreeNode.Test4();
        test26BinaryTreeNode.Test5();
        test26BinaryTreeNode.Test6();
        test26BinaryTreeNode.Test7();
        test26BinaryTreeNode.Test8();
        test26BinaryTreeNode.Test9();

    }

}
