package com.cpq.singleton;


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题16：数值的整数次方
// 题目：实现函数double Power(double base, int exponent)，求base的exponent
// 次方。不得使用库函数，同时不需要考虑大数问题。

public class Test16Power {
   static boolean flag = false;
    public double Power(double base,int expoent){

        if (equal(base,0.0) && expoent <0) {
            flag = true;
            return 0.0;
        }
        int absExpoent = Math.abs(expoent);
        double resutlt = PowerWithAbsExponent(base,absExpoent);
        if (expoent <0)
            return 1.0 /resutlt;
        return resutlt;
    }

    private double PowerWithAbsExponent(double base, int absExpoent) {
        if (absExpoent == 0)
            return 1;
        if (absExpoent == 1)
            return base;

        double result = PowerWithAbsExponent(base, absExpoent >> 1);
         result *= result;

        if ((absExpoent & 1) == 1)
             result *= base;
        return result;
    }
    private boolean equal(double num1, double num2)
    {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        else
            return false;
    }

    // ====================测试代码====================
   static void Test(String testName, double base, int exponent, double expectedResult ,boolean expectedFlag)
    {
        final Test16Power test16Power = new Test16Power();
        double result = test16Power. Power(base, exponent);
        if (test16Power.equal(result, expectedResult) && flag == expectedFlag)
            System.out.println(testName +" passed " +result);

        else
            System.out.println(testName +" FAILED " +result );

    }

    public static void main(String[] args) {
        // 底数、指数都为正数
        Test("Test1", 2, 3, 8, false);

        // 底数为负数、指数为正数
        Test("Test2", -2, 3, -8, false);

        // 指数为负数
        Test("Test3", 2, -3, 0.125, false);

        // 指数为0
        Test("Test4", 2, 0, 1, false);

        // 底数、指数都为0
        Test("Test5", 0, 0, 1, false);

        // 底数为0、指数为正数
        Test("Test6", 0, 4, 0, false);

        // 底数为0、指数为负数
        Test("Test7", 0, -4, 0, true);

    }

}
