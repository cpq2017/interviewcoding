package com.cpq.singleton;


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题23：链表中环的入口结点
// 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
// 环的入口结点是结点3。
public class Test23MeetingNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode MettingNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head.next;
        if (slow == null)
            return null;

        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }

        return null;
    }

    ListNode EntryNodeOfLoop(ListNode head) {
        final ListNode meetNode = MettingNode(head);
        if (meetNode == null)
            return null;
        int nodesLoop = 1;
        ListNode node = meetNode;
        while (node.next != meetNode) {
            node = node.next;
            ++nodesLoop;

        }
        node = head;
        for (int i = 0; i < nodesLoop; i++) {
            node = node.next;
        }
        ListNode node2 = head;
        while (node != node2) {
            node = node.next;
            node2 = node2.next;
        }
        return node;

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("fist while fast" + fast.val);
            System.out.println("fist while slow" + slow.val);
            if (fast == slow) {
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                     System.out.println("fast == slow while slow" + slow.val);
                     System.out.println("fast == slow while entry" + entry.val);
                }
                return entry;
            }
        }
        return null;
    }


    // A list has a node, without a loop
    void Test1() {
        ListNode pNode1 = new ListNode(1);

        Test("Test1", pNode1, null);

    }

    // A list has a node, with a loop
    void Test2() {
        ListNode pNode1 = new ListNode(1);
        pNode1.next = pNode1;

        Test("Test2", pNode1, pNode1);

    }

    // A list has multiple nodes, with a loop
    void Test3() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode5.next = pNode3;

        Test("Test3", pNode1, pNode3);

    }

    // A list has multiple nodes, with a loop 
    void Test4() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode5.next = pNode1;

        Test("Test4", pNode1, pNode1);

    }

    // A list has multiple nodes, with a loop 
    void Test5() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        pNode5.next = pNode5;

        Test("Test5", pNode1, pNode5);


    }

    // A list has multiple nodes, without a loop 
    void Test6() {
        ListNode pNode1 = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);

        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;

        Test("Test6", pNode1, null);


    }

    // Empty list
    void Test7() {
        Test("Test7", null, null);
    }

    // ==================== Test Code ====================
    void Test(String testName, ListNode pHead, ListNode entryNode) {
        if (testName != null)
            if (entryNode != null)
                System.out.print("begins: " + testName + ",EntryNode " + entryNode.val);
            else
                System.out.print("begins: " + testName + ",EntryNode null");
//        if (EntryNodeOfLoop(pHead) == entryNode)
        if (detectCycle(pHead) == entryNode)
            System.out.println(" Passed.");
        else
            System.out.println(" FAILED.");
    }


    public static void main(String[] args) {
        final Test23MeetingNode test23MeetingNode = new Test23MeetingNode();
//        test23MeetingNode.Test1();
//        test23MeetingNode.Test2();
        test23MeetingNode.Test3();
//        test23MeetingNode.Test4();
//        test23MeetingNode.Test5();
//        test23MeetingNode.Test6();
//        test23MeetingNode.Test7();

    }
}
