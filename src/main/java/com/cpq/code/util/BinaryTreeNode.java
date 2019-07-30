package com.cpq.code.util;

public class BinaryTreeNode {

    public int m_dbValue;
    public BinaryTreeNode m_pLeft;
    public BinaryTreeNode m_pRight;

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

    public  static void PrintTree( BinaryTreeNode pRoot)
    {
        PrintTreeNode(pRoot);

        if(pRoot != null)
        {
            if(pRoot.m_pLeft != null)
                PrintTree(pRoot.m_pLeft);

            if(pRoot.m_pRight != null)
                PrintTree(pRoot.m_pRight);
        }
    }
    public static void PrintTreeNode(BinaryTreeNode pNode)
    {
        if(pNode != null)
        {
            System.out.printf("value of this node is: %d\n", pNode.m_dbValue);

            if(pNode.m_pLeft != null)
                System.out.printf("value of its left child is: %d.\n", pNode.m_pLeft.m_dbValue);
            else
                System.out.printf("left child is null.\n");

            if(pNode.m_pRight != null)
                System.out.printf("value of its right child is: %d.\n", pNode.m_pRight.m_dbValue);
            else
                System.out.printf("right child is null.\n");
        }
        else
        {
            System.out.printf("this node is null.\n");
        }

        System.out.printf("\n");
    }
}
