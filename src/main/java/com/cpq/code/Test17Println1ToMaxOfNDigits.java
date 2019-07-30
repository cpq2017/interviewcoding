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

// 面试题17：打印1到最大的n位数
// 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
// 打印出1、2、3一直到最大的3位数即999。

public class Test17Println1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits_1 (int n){
        int num =1;
        for (int i = 0; i < n ; i++) {
            num *= 10;
        }
        for (int i = 1; i < num ; i++) {
            System.out.println(i);
        }
    }
    public void print1ToMaxOfNDigits_2 (int n){
        if (n <0)
            return;
        char[] number = new char[n];
//        number[n] = '\0';
        for (int i = 0; i < 10 ; i++) {
            number [0] = (char)(i +'0');
            Print1ToMaxOfDigitsRecursively(number,n,0);
        }
    }

    private void Print1ToMaxOfDigitsRecursively(char[] number, int length, int index) {
        if (index == length -1) {
            Println(number);
            return;
        }

        for (int i = 0; i <10 ; i++) {
            number[index +1] = (char) (i+ '0');
            Print1ToMaxOfDigitsRecursively(number,length,index +1);
        }

    }

    private void Println(char[] number) {
        boolean flag = true;
        for (int i = 0; i < number.length ; ++i) {
             if (flag && number[i] !='0')
                 flag =false;

             if(! flag)
                 System.out.print(number[i]);
        }
        System.out.println();
    }
    public void  print1ToMaxOfNDigits_3(int n){
        if (n < 0)
            return;
        if (n==0)
            System.out.println(0);
        final char[] chars = new char[n];
        for (int i = 0; i < n ; i++) {
            chars[i] = '9';
        }
        for (int i = chars.length-1; i >=0; i--) {
            while (chars[i] >= '0'){

            }
        }
    }

    public static void main(String[] args) {
        final Test17Println1ToMaxOfNDigits test17 = new Test17Println1ToMaxOfNDigits();
        test17.print1ToMaxOfNDigits_2(3);
    }

}
