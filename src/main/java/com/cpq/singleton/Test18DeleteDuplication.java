package com.cpq.singleton;

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

// 面试题18（二）：删除链表中重复的结点
// 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
// 结点被删除之后，链表如图3.4（b）所示。

//    https://www.cnblogs.com/yongh/p/9672004.html

public class Test18DeleteDuplication {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int value, ListNode nextNode) {
            this.val =value;
            this.next=nextNode;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null||pHead.next==null) //空结点或者仅一个结点
            return pHead;
        ListNode preNode = null;
        ListNode curNode = pHead;

        while(curNode!=null){
            boolean needDelete=false;
            if(curNode.next!=null && curNode.val==curNode.next.val)
                needDelete=true;
            if(!needDelete){  //当前结点不重复
                preNode=curNode;
                curNode=curNode.next;
            }else{            //当前结点重复
                int dupValue=curNode.val;
                ListNode toBeDel = curNode;
                while(toBeDel!=null&&toBeDel.val==dupValue){
                    //这里删除暂时不涉及前一结点操作，其实主要是找出后面第一个不重复结点
                    toBeDel = toBeDel.next;
                }
                if(preNode==null){  //说明删除的结点为头结点
                    pHead=toBeDel;
                }else{
                    preNode.next=toBeDel;
                }
                curNode=toBeDel;  //这个结点还是可能会出现重复的，所以不能=next
            }
        }
        return pHead;
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode pro = null;
        ListNode curr = pHead;
        while (curr != null){
            ListNode next = curr.next;
            boolean needdelete = false;
            if (next != null && curr.val == next.val)
                needdelete = true;
            //非重复节点
            if (!needdelete){
                pro = curr;
                curr = curr.next;
            }else {
                int val = curr.val;
                ListNode deletenode = curr;
                while (deletenode != null && deletenode.val == val){
                    deletenode = deletenode.next;
                }
            if (pro == null)
                pHead = deletenode;
            else
                pro.next = deletenode;

                curr = deletenode;
            }
        }

        return pHead;
    }



    //========测试代码======
    void test(ListNode pHead) {
        System.out.println("-----------");
        System.out.print("The original list is: ");
        ListNode curr=pHead;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        pHead=deleteDuplication2(pHead);
        System.out.print("The result list is: ");
        curr=pHead;
        if(curr!=null) {
            while(curr.next!=null) {
                System.out.print(curr.val+",");
                curr=curr.next;
            }
            System.out.println(curr.val);
        }else {
            System.out.println();
        }
        System.out.println("-----------");
    }


    /**
     * 重复结点位于链表头部
     */
    void test1() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 重复结点位于链表尾部
     */
    void test2() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 重复结点位于链表中部
     */
    void test3() {
        ListNode p4=new ListNode(3, null);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 连续出现重复结点
     */
    void test4() {
        ListNode p6=new ListNode(3, null);
        ListNode p5=new ListNode(3, p6);
        ListNode p4=new ListNode(2, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 多个重复结点
     */
    void test5() {
        ListNode p6=new ListNode(3, null);
        ListNode p5=new ListNode(3, p6);
        ListNode p4=new ListNode(3, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 无重复结点
     */
    void test6() {
        ListNode p6=new ListNode(6, null);
        ListNode p5=new ListNode(5, p6);
        ListNode p4=new ListNode(4, p5);
        ListNode p3=new ListNode(3, p4);
        ListNode p2=new ListNode(2, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    /**
     * 单个结点
     */
    void test7() {
        ListNode p1=new ListNode(6, null);
        test(p1);
    }

    /**
     * null
     */
    void test8() {
        ListNode p1=null;
        test(p1);
    }

    /**
     * 多个重复结点
     */
    void test9() {
        ListNode p7=new ListNode(3, null);
        ListNode p6=new ListNode(3, p7);
        ListNode p5=new ListNode(4, p6);
        ListNode p4=new ListNode(3, p5);
        ListNode p3=new ListNode(2, p4);
        ListNode p2=new ListNode(1, p3);
        ListNode p1=new ListNode(1, p2);
        test(p1);
    }

    public static void main(String[] args) {
        Test18DeleteDuplication demo= new Test18DeleteDuplication();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
        demo.test9();
    }

}
