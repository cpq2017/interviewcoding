package com.cpq.singleton;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题22：链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。

public class Test22FindKthToTail {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail2(ListNode head, int k) {

        if (head == null || k == 0)
            return null;

        ListNode result = null;
        ListNode advenceNode = head;
        for (int i = 0; i < k-1; i++) {
            if (advenceNode.next != null)
                advenceNode = advenceNode.next;
            else
                return null;
        }
        result = head;
        while (advenceNode.next != null){
            result =result.next;
            advenceNode = advenceNode.next;
        }
        return result;
    }

    //=====================测试代码=======================

    /*
     * null
     */
    void test1() {
        ListNode head = null;
        ListNode result = FindKthToTail2(head, 1);
        if (result == null)
            System.out.println("test1 passed! " );
        else
            System.out.println("test1 failed! " +result.val);
    }

    /*
     * k超出范围
     */
    void test2() {
        ListNode head = new ListNode(2);
        ListNode result = FindKthToTail2(head, 2);
        if (result == null)
            System.out.println("test2 passed! ");
        else
            System.out.println("test2 failed! " );
    }

    /*
     * 单个结点
     */
    void test3() {
        ListNode head = new ListNode(1);
        ListNode result = FindKthToTail2(head, 1);
        if (result.val == 1)
            System.out.println("test3 passed! " +result.val);
        else
            System.out.println("test3 failed! " +result.val);
    }

    /*
     * 尾结点
     */
    void test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = FindKthToTail2(node1, 1);
        if (result.val == 4)
            System.out.println("test4 passed! " +result.val);
        else
            System.out.println("test4 failed! " +result.val);
    }

    /*
     * 中间结点
     */
    void test5() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = FindKthToTail2(node1, 2);
        if (result.val == 3)
            System.out.println("test5 passed! " +result.val);
        else
            System.out.println("test5 failed! " +result.val);
    }

    /*
     * 头结点
     */
    void test6() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = FindKthToTail2(node1, 4);
        if (result.val == 1)
            System.out.println("test6 passed! " +result.val);
        else
            System.out.println("test6 failed! " +result.val);
    }

    public static void main(String[] args) {
        Test22FindKthToTail demo = new Test22FindKthToTail();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
    }
}
