package com.cpq.singleton;


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题15：二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。

public class Test15NumberOf1InBinary {
    public int NumberOf1_Solution1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public int NumberOf1_Solution2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    // =========测试代码=========

    void test(String testName, int n, int expected) {
        if (testName != null)
            System.out.println(testName + ":");
        if (NumberOf1_Solution1(n) == expected) {
            System.out.print("    soluton1:" + "passed  ");
        } else {
            System.out.print("    solution1:" + "failed  ");
        }

        if (NumberOf1_Solution2(n) == expected) {
            System.out.println("soluton2:" + "passed  ");
        } else {
            System.out.println("solution2:" + "failed  ");
        }
    }

    void test1() {
        test("Test for 0", 0, 0);
    }

    void test2() {
        test("Test for 1", 1, 1);
    }

    void test3() {
        test("Test for 10", 10, 2);
    }

    void test4() {
        test("Test for 0x7FFFFFFF", 0x7FFFFFFF, 31);
    }

    void test5() {
        test("Test for 0xFFFFFFFF", 0xFFFFFFFF, 32);
    }

    void test6() {
        test("Test for 0x80000000", 0x80000000, 1);
    }

    public static void main(String[] args) {
        Test15NumberOf1InBinary demo = new Test15NumberOf1InBinary();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
    }
}
