package com.cpq.code;


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题25：合并两个排序的链表
// 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
// 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
// 表3所示。

public class Test25Merge {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        else if (node2 == null)
            return node1;

        ListNode mergeHead = null;

        if (node1.val < node2.val) {
            mergeHead = node1;
            mergeHead.next = Merge(node1.next, node2);
        } else {
            mergeHead = node2;
            mergeHead.next = Merge(node1, node2.next);
        }

        return mergeHead;
    }

    // ====================测试代码====================
    ListNode Test(String testName, ListNode pHead1, ListNode pHead2)
    {
        if(testName != null)
            System.out.print("begins:"+ testName);

        System.out.print("The first list is:\n");
        PrintList(pHead1);

        System.out.print("The second list is:\n");
        PrintList(pHead2);

        System.out.print("The merged list is:\n");
        ListNode pMergedHead = Merge(pHead1, pHead2);
        PrintList(pMergedHead);

        System.out.print("\n\n");

        return pMergedHead;
    }

    // list1: 1->3->5
// list2: 2->4->6
    void Test1()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode5 = new ListNode(5);

        ConnectListNodes(pNode1, pNode3);
        ConnectListNodes(pNode3, pNode5);

        ListNode pNode2 = new ListNode(2);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode6 = new ListNode(6);

        ConnectListNodes(pNode2, pNode4);
        ConnectListNodes(pNode4, pNode6);

        ListNode pMergedHead = Test("Test1", pNode1, pNode2);

    }

    // 两个链表中有重复的数字
// list1: 1->3->5
// list2: 1->3->5
    void Test2()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode5 = new ListNode(5);

        ConnectListNodes(pNode1, pNode3);
        ConnectListNodes(pNode3, pNode5);

        ListNode pNode2 = new ListNode(1);
        ListNode pNode4 = new ListNode(3);
        ListNode pNode6 = new  ListNode(5);

        ConnectListNodes(pNode2, pNode4);
        ConnectListNodes(pNode4, pNode6);

        ListNode pMergedHead = Test("Test2", pNode1, pNode2);


    }

    // 两个链表都只有一个数字
// list1: 1
// list2: 2
    void Test3()
    {
        ListNode pNode1 = new  ListNode(1);
        ListNode pNode2 = new ListNode(2);

        ListNode pMergedHead = Test("Test3", pNode1, pNode2);


    }

    // 一个链表为空链表
// list1: 1->3->5
// list2: 空链表
    void Test4()
    {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode5 = new ListNode(5);

        ConnectListNodes(pNode1, pNode3);
        ConnectListNodes(pNode3, pNode5);

        ListNode pMergedHead = Test("Test4", pNode1, null);

    }

    private void ConnectListNodes(ListNode pNode1, ListNode pNode3) {
        pNode1.next=pNode3;
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
    // 两个链表都为空链表
// list1: 空链表
// list2: 空链表
    void Test5()
    {
        ListNode pMergedHead = Test("Test5", null, null);
    }

    public static void main(String[] args) {
        final Test25Merge test25Merge = new Test25Merge();
        test25Merge.Test1();
        test25Merge.Test2();
        test25Merge.Test3();
        test25Merge.Test4();
        test25Merge.Test5();

    }

}
