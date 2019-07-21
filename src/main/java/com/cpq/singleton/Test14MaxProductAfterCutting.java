package com.cpq.singleton;


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题14：剪绳子
// 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
// 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
// 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
// 时得到最大的乘积18。

public class Test14MaxProductAfterCutting {
    // ====================动态规划====================
    public int maxProductAfterCutting_solution(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] ints = new int[length + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 3;
        int max = 0;
        for (int i = 4; i <= length ; i++) {
            max = 0;
            for (int j = 0; j <= i/2; j++) {
                int product = ints[j] * ints[i-j];
                if(max < product){
                    max = product;
                }
                ints[i]=max;
            }
        }
        max = ints[length];

        return max;
    }

    // ====================贪婪算法====================
    public int maxProductAfterCutting_solution2(int length){
        if (length <2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        //尽可能多地去剪长度为3的绳子

        int timesOf3 = length/3;
        if (length - timesOf3 *3 ==1)
            timesOf3 -= 1;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 3*1。
        int timesOf2 = (length - timesOf3*3) /2;
        return ((int)Math.pow(3,timesOf3)* (int)Math.pow(2,timesOf2));
    }

    public static void main(String[] args) {
        Test14MaxProductAfterCutting test14MaxProductAfterCutting = new Test14MaxProductAfterCutting();
        int i = test14MaxProductAfterCutting.maxProductAfterCutting_solution2(8);
        System.out.println(i);
    }
}
