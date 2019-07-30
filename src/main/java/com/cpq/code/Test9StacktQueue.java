package com.cpq.code;

import java.util.Stack;

/**
 * 面试题9： 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 实现两个方法 appendTail :在队列尾部插入节点
 * deleteHead :在队列头部删除节点的功能
 */
public class Test9StacktQueue {
   private static Stack<Integer> s1 = new Stack();
   private static   Stack<Integer> s2 = new Stack();
   private Stack queue (){
       if (s2.empty() ){
           while ( !s1.empty())
               s2.push(s1.pop());
       }
       return s2;
   }
    public int deleteHead (){
        queue();

        if (!s2.empty()){
            return s2.pop();
        }else {
           throw new RuntimeException("队列中无数据！！");

        }


    }
    public int appendTail (int tail){
       s1.push(tail);
       return s1.peek();

    }
    public void printlnQuene(){


        System.out.print(s2.toString()+"  ");
           System.out.print(s1.toString());
    }

    public static void main(String[] args) {
        Test9StacktQueue test9StatQueue = new Test9StacktQueue();
        for (int i = 0; i < 10; i++) {
            System.out.println("add num "+test9StatQueue.appendTail(i));
        }
        test9StatQueue.printlnQuene();

        for (int i = 0; i < 5; i++) {
            System.out.println("del num "+test9StatQueue.deleteHead());
        }
        test9StatQueue.printlnQuene();
//
//        test9StatQueue.deleteHead();


   }


}
