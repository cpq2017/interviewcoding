package com.cpq.singleton;
//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题21：调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分。

import java.util.Arrays;

public class Test21ReorderOddEven {
    public void reOrderArray(int[] arr){
        if (arr == null || arr.length <=1)
            return ;
        int index=0;
        int end = arr.length-1;
        while (index< end){
            while (index < end && (arr[index] &1) != 0)
                index++;
            while (index < end && (arr[end] & 1 ) == 0)
                end--;
            if(index < end){
                int temp = arr[index];
                arr[index] = arr[end];
                arr[end] = temp;
            }

        }


    }
    void test1() {
        int[] array = null;
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+ Arrays.toString(array));
        System.out.println();
    }

    void test2() {
        int[] array = {};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test3() {
        int[] array = {-2,4,-6,1,-3,5};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test4() {
        int[] array = {-1,3,-5,2,-4,6};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test5() {
        int[] array = {-1,2,-3,4,-5,6};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test6() {
        int[] array = {2,2,1,3,4,1};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    void test7() {
        int[] array = {1};
        System.out.println("原始数组："+Arrays.toString(array));
        reOrderArray(array);
        System.out.println("调整结果："+Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        Test21ReorderOddEven demo = new Test21ReorderOddEven();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
