package com.cpq.code;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题30：包含min函数的栈
// 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
// 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。

import java.util.Stack;

public class Test30StackWithMin {
    Stack<Integer>  m_data = new Stack<Integer>();
    Stack<Integer> m_min = new Stack<>();
    public void push(int num) {
        m_data.push(num);
        if (m_min.empty() || num < m_min.peek())
            m_min.push(num);
        else
            m_min.push(m_min.peek());
    }

    public Integer pop(){
        if (!m_data.empty() && !m_min.empty()){
            m_data.pop();
            return m_min.pop();
        }else
           return null;
    }
    public Integer min(){
        if (!m_data.empty() && !m_min.empty())
            return m_min.peek();
        else
            return null;
    }

    public static void main(String[] args) {
        final Test30StackWithMin test30 = new Test30StackWithMin();
        test30.push(3);
        System.out.println("min "+test30.min());
        test30.push(4);
        System.out.println("min "+test30.min());
        test30.push(2);
        System.out.println("min "+test30.min());
        test30.push(1);
        System.out.println("min "+test30.min());
        System.out.println("pop "+test30.pop());
        System.out.println("min "+test30.min());
        System.out.println("pop "+test30.pop());
        System.out.println("min "+test30.min());
        System.out.println("pop "+test30.pop());
        System.out.println("min "+test30.min());
        System.out.println("pop "+test30.pop());
        System.out.println("min "+test30.min());

    }
}
