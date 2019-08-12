package com.cpq.code;

//二叉树的遍历

import com.cpq.code.util.BinaryTreeNode;

import java.util.Stack;

/**
 * 二叉树是一种非常重要的数据结构，非常多其他数据结构都是基于二叉树的基础演变而来的。
 * 对于二叉树，有深度遍历和广度遍历，
 * 深度遍历有前序、中序以及后序三种遍历方法，
 * 广度遍历即我们寻常所说的层次遍历。
 * 由于树的定义本身就是递归定义
 * ，因此採用递归的方法去实现树的三种遍历不仅easy理解并且代码非常简洁，
 * 而对于广度遍历来说，须要其他数据结构的支撑。比方堆了。
 * ---------------------
 * <p>
 * 原文链接：https://blog.csdn.net/qq_37859539/article/details/81462171
 * <p>
 * 四种基本的遍历思想为：
 * <p>
 * 前序遍历：根结点 —> 左子树 —> 右子树
 * <p>
 * 中序遍历：左子树—> 根结点 —> 右子树
 * <p>
 * 后序遍历：左子树 —> 右子树 —> 根结点
 * <p>
 * 层次遍历：仅仅需按层次遍历就可以
 * <p>
 * 比如。求以下二叉树的各种遍历
 * <p>
 * 1
 * /  \
 * 2    3
 * / \   /
 * 4   5  6
 * / \
 * 7   8
 * <p>
 * 前序遍历：1 2 4 5 7 8 3 6
 * <p>
 * 中序遍历：4 2 7 5 8 1 6 3
 * <p>
 * 后序遍历：4 7 8 5 2 6 3 1
 * <p>
 * 层次遍历：1 2 3 4 5 6 7 8
 */
public class BinaryTreeTraverse {
    //一、前序遍历
    //
    //1）依据上文提到的遍历思路：根结点 —> 左子树 —> 右子树，非常easy写出递归版本号：
    public void preOrderRecur(BinaryTreeNode root) {
        if (root == null)
            return;
        System.out.print(root.m_dbValue + " ");
        preOrderRecur(root.m_pLeft);
        preOrderRecur(root.m_pRight);
    }
    //2）如今讨论非递归的版本号：
    // 依据前序遍历的顺序，优先訪问根结点。
    // 然后在訪问左子树和右子树。所以。对于随意结点node。
    // 第一部分即直接訪问之，之后在推断左子树是否为空，不为空时即反复上面的步骤，直到其为空。
    // 若为空。则须要訪问右子树。
    // 注意。在訪问过左孩子之后。须要反过来訪问其右孩子。
    // 所以，须要栈这样的数据结构的支持。对于随意一个结点node，详细过程例如以下：
    //
    //a)訪问之，并把结点node入栈。当前结点置为左孩子；
    //
    //b)推断结点node是否为空，若为空。则取出栈顶结点并出栈，将右孩子置为当前结点；
    // 否则反复a)步直到当前结点为空或者栈为空（能够发现栈中的结点就是为了訪问右孩子才存储的）

    //先序遍历的非递归的写法，反着它的顺序写
    // 1.先放中节点
    // 2.有右节点放右节点
    // 3.有左节点放左节点
    public void preOrderUnRecur(BinaryTreeNode root) {
        if (root == null)
            return;
        final Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = null;
        stack.push(root);
        while (!stack.empty()) {
            node = stack.pop();
            System.out.print(node.m_dbValue + " ");
            if (node.m_pRight != null)
                stack.push(node.m_pRight);
            if (node.m_pLeft != null)
                stack.push(node.m_pLeft);

        }

    }

    //    二、中序遍历
    //1)依据上文提到的遍历思路：左子树 —> 根结点 —> 右子树，非常easy写出递归版本号：
    public void inOrderRecur(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderRecur(root.m_pLeft);
        System.out.print(root.m_dbValue +" ");
        inOrderRecur(root.m_pRight);
    }

    public static void main(String[] args) {
        final BinaryTreeNode[] nodes = BinaryTreeNode.getBinaryTreeNodes();
        int i = 1;
        for (BinaryTreeNode node : nodes) {
            final BinaryTreeTraverse traverse = new BinaryTreeTraverse();
            System.out.println("test 前序 非递归" + i);

            traverse.preOrderRecur(node);
            System.out.println();
            System.out.println("test 前序 递归" + i);
            traverse.preOrderRecur(node);
            System.out.println();

            System.out.println("test 中序 递归" + i);
            traverse.inOrderRecur(node);
            System.out.println();
            i++;
        }
    }


}
