package com.cpq.code;

/*******************************************************************
 Copyright(c) 2016, Harry He
 All rights reserved.

 Distributed under the BSD license.
 (See accompanying file LICENSE.txt at
 https://github.com/zhedahht/CodingInterviewChinese2/blob/master/LICENSE.txt)
 *******************************************************************/

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题18（一）：在O(1)时间删除链表结点
// 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
// 结点。

public class Test18DeleteNode {
    class ListNode{
        int value;
        ListNode next;

        public ListNode(int value,ListNode nextNode) {
            this.value=value;
            this.next=nextNode;
        }
    }
    public void DeleNode(ListNode head,ListNode deletedNode){
        if (head == null || deletedNode == null)
            return;
        // 要删除的结点不是尾结点
        if (deletedNode.next != null){
            ListNode next = deletedNode.next;
            deletedNode.value = next.value;
            deletedNode.next = next.next;

            next = null;
        }
        // 链表只有一个结点，删除头结点（也是尾结点）
        else if (head == deletedNode) {
            deletedNode = null;
            head = null;
        }
        // 链表中有多个结点，删除尾结点
        else {
            ListNode node = head;
            while (node.next != deletedNode){
                node = node.next;
            }

            node.next = null;
            deletedNode = null;

        }

    }
}
