package com.cpq.singleton;

/**
 * 面试题8 ： 二叉树的下一个节点
 * 给定一棵和其中的一个节点，如何找出中序遍历序列的
 * 下一个节点？树中的节点除了有两个分别指向左、右子
 * 节点的指针，还有一个指向父节点指针。
 *
 */
public class Test8TreeNextNode {
      class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode father;
        public TreeNode(int val){
            this.value = val;
        }
    }

    public  TreeNode findnextnode(TreeNode node){
        if(node == null){
            return  null;
        }
        if(node.right != null){
            while (node.right.left != null){
                node = node.right.left;
            }
            return node.right;
        } else if (node.father != null){

            while (node.father != null && node ==node.father.right  ){
                node = node.father;
//                node.father = node.father.father;
            }

        }

        return node.father;
    }

    // ==================================测试代码==================================
    //创建树较为繁琐，未包括所有测试代码。
    public void test1() {
        TreeNode node = null;
        TreeNode nextNode = findnextnode(node);
        if(nextNode!=null)
            System.out.println(nextNode.value);
        else
            System.out.println("无下一结点");
    }

    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.father = node1;
        node3.father = node1;
        node4.left=node1;
        node1.father=node4;
        node4.right =node5;
        node5.father=node4;
        TreeNode nextNodeOf1=findnextnode(node1);
        TreeNode nextNodeOf2=findnextnode(node2);
        TreeNode nextNodeOf3=findnextnode(node3);
        TreeNode nextNodeOf4=findnextnode(node4);
        if(nextNodeOf1!=null)
            System.out.println("1结点的下一个结点值为："+nextNodeOf1.value);
        else
            System.out.println("1结点无下一结点");
        if(nextNodeOf2!=null)
            System.out.println("2结点的下一个结点值为："+nextNodeOf2.value);
        else
            System.out.println("2结点无下一结点");
        if(nextNodeOf3!=null)
            System.out.println("3结点的下一个结点值为："+nextNodeOf3.value);
        else
            System.out.println("3结点无下一结点");
        if(nextNodeOf4!=null)
            System.out.println("4结点的下一个结点值为："+nextNodeOf4.value);
        else
            System.out.println("4结点无下一结点");
    }

    public static void main(String[] args) {
        Test8TreeNextNode demo = new Test8TreeNextNode();
        System.out.print("test1:");
        demo.test1();
        System.out.print("test2:");
        demo.test2();
    }

}
