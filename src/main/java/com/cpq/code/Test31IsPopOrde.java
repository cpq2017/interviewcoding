package com.cpq.code;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题31：栈的压入、弹出序列
// 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
// 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
// 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
// 4、3、5、1、2就不可能是该压栈序列的弹出序列。


import java.util.Stack;

public class Test31IsPopOrde {

    public boolean IsPopOrder(int [] pushA,int [] popA){
        if(pushA==null || popA==null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if(popA.length!=pushA.length || pushA.length==0)
            return false;
        int popIndex=0;

        for(int pushIndex=0; pushIndex<pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while(!stack.empty() && stack.peek()==popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    public boolean IsPopOrder2(int[] push,int[] pop,int length){
        if (push == null || pop == null)
            return false;
        if (push.length != pop.length || push.length <= 0)
            return false;
        int popindex =0;

        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < push.length ; i++) {
            stack.push(push[i]);
            while (!stack.empty() && stack.peek() == pop[popindex]){
                stack.pop();
                popindex ++;
            }
        }
        return stack.empty();

    }

    // ====================测试代码====================
    void Test(String testName, int[ ] pPush, int[ ] pPop, int nLength, boolean expected)
    {
        if(testName != null)
            System.out.printf("%s begins: ", testName);

        if(IsPopOrder2(pPush, pPop, nLength) == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("failed.\n");
    }

    void Test1()
    {
    int nLength = 5;
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};

        Test("Test1", push, pop, nLength, true);
    }

    void Test2()
    {
    int nLength = 5;
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 2, 1};

        Test("Test2", push, pop, nLength, true);
    }

    void Test3()
    {
    int nLength = 5;
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};

        Test("Test3", push, pop, nLength, false);
    }

    void Test4()
    {
    int nLength = 5;
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 1, 2};

        Test("Test4", push, pop, nLength, false);
    }

    // push和pop序列只有一个数字
    void Test5()
    {
    int nLength = 1;
        int[] push = {1};
        int[] pop = {2};

        Test("Test5", push, pop, nLength, false);
    }

    void Test6()
    {
    int nLength = 1;
        int[] push = {1};
        int[] pop = {1};

        Test("Test6", push, pop, nLength, true);
    }

    void Test7()
    {
        Test("Test7", null, null, 0, false);
    }

    public static void main(String[] args) {
        final Test31IsPopOrde test31IsPopOrde = new Test31IsPopOrde();
        test31IsPopOrde.Test1();
        test31IsPopOrde.Test2();
        test31IsPopOrde.Test3();
        test31IsPopOrde.Test4();
        test31IsPopOrde.Test5();
        test31IsPopOrde.Test6();
        test31IsPopOrde.Test7();
    }

}
