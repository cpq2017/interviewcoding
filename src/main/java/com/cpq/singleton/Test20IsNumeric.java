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

// 面试题20：表示数值的字符串
// 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
// 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
// “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是

public class Test20IsNumeric {
    int i = 0;

    public boolean isNumeric2(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int[] index = new int[1];
        index[0] = 0; // 用于记录当前字符位置
        // 先判断A
        boolean isNumeric; //用于记录是否满足条件
        isNumeric = isInteger(str, index);
        // 判断B
        if (index[0] < str.length && (str[index[0]] == '.')) {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B和A.和A.B形式均可以
        }
        // 判断e后面的A
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length)
            return true;
        else
            return false;
    }
    boolean isNumeric(char[] chr) {
        if (chr == null || chr.length == 0)
            return false;
        boolean numeric;

         numeric = scanInteger(chr);

        if (i < chr.length && chr[i] == '.') {
            i++;
            numeric = scanUnsignnum(chr) || numeric;
        }
        if (i < chr.length && (chr[i] == 'e' || chr[i] == 'E')) {
            i++;
            numeric = scanInteger(chr) && numeric;
        }

        if (numeric && i == chr.length)
            return true;
        else
            return false;

    }


    private boolean isInteger(char[] str, int[] index) { // 用int[]才能传值，int的话需要定义index为全局变量
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        return isUnsignedInteger(str, index);
    }

    private boolean scanInteger(char[] chr) {
        if (i < chr.length && (chr[i] == '+' || chr[i] == '-'))
            i++;
        return scanUnsignnum(chr);

    }

    private boolean scanUnsignnum(char[] chr) {
        int index = i;
        while (i < chr.length && (chr[i] - '0' >= 0 && chr[i] - '0' <= 9)) {
            i++;
        }
        if (i > index)
            return true;
        else
            return false;
    }

    private boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index[0]++;
        if (index[0] > start)
            return true;
        else
            return false;
    }
    // =======测试代码=========
    void test(String testName, char[] str, boolean expected) {
        if (str == null) {
            System.out.println(testName + "：null");
            return;
        }
        final Test20IsNumeric test20 = new Test20IsNumeric();
        System.out.print(testName + "：");
        if (test20.isNumeric(str) == expected )
            System.out.println(new String(str) +" passed!");
        else
            System.out.println(new String(str) +" failed!");
    }

    void test1() {
        char[] str = null;
        test("test1", str, false);
    }

    void test2() {
        char[] str = {};
        test("test2", str, false);
    }

    void test3() {
        String string = "e3";
        char[] str = string.toCharArray();
        test("test3", str, false);
    }

    void test4() {
        String string = "3e1.2";
        char[] str = string.toCharArray();
        test("test4", str, false);
    }

    void test5() {
        String string = "e3";
        char[] str = string.toCharArray();
        test("test5", str, false);
    }

    void test6() {
        String string = "1.2e3";
        char[] str = string.toCharArray();
        test("test6", str, true);
    }

    void test7() {
        String string = "-.2e3";
        char[] str = string.toCharArray();
        test("test7", str, true);
    }

    void test8() {
        String string = "-.2e-3";
        char[] str = string.toCharArray();
        test("test8", str, true);
    }

    void test9() {
        String string = "1.e-3";
        char[] str = string.toCharArray();
        test("test9", str, true);
    }

    void test10() {
        String string = "1.";
        char[] str = string.toCharArray();
        test("test10", str, true);
    }

    void test11() {
        String string = ".2";
        char[] str = string.toCharArray();
        test("test11", str, true);
    }

    void test12() {
        String string = "12e3";
        char[] str = string.toCharArray();
        test("test12", str, true);
    }

    public static void main(String[] args) {
        Test20IsNumeric demo = new Test20IsNumeric();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
        demo.test9();
        demo.test10();
        demo.test11();
        demo.test12();
    }
}
