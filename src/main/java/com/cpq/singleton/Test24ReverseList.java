package com.cpq.singleton;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题24：反转链表
// 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
// 头结点。

public class Test24ReverseList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    //三个指针实现
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode next = head.next;
        ListNode node = head;
        ListNode pre = null;
        while (next != null) {
            node.next = pre;
            pre = node;
            node = next;
            next = node.next;

        }
        node.next = pre;
        return node;
    }


    // ====================测试代码====================
    ListNode Test(ListNode pHead) {
        System.out.print("The original list is: ");
        PrintList(pHead);

        ListNode pReversedHead = ReverseList(pHead);

        System.out.print("The reversed list is: ");
        PrintList(pReversedHead);

        return pReversedHead;
    }

    private void PrintList(ListNode pReversedHead) {
        StringBuffer buffer = new StringBuffer();
        while (pReversedHead != null){
            buffer.append(pReversedHead.val);
            buffer.append(",");
            pReversedHead = pReversedHead.next;
        }
        System.out.println(buffer.toString());

    }


    // 输入的链表有多个结点
    void Test1() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;

        ListNode pReversedHead = Test(pNode1);

    }

    // 输入的链表只有一个结点
    void Test2() {
        ListNode pNode1 = new ListNode(1);

        ListNode pReversedHead = Test(pNode1);

   }

    // 输入空链表
    void Test3() {
        Test(null);
    }

    public static void main(String[] args) {
        final Test24ReverseList test24ReverseList = new Test24ReverseList();
        test24ReverseList.Test1();
        test24ReverseList.Test2();
        test24ReverseList.Test3();
    }
}
