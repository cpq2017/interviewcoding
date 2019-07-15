package com.cpq.singleton;


import java.io.CharArrayWriter;

/**
 *
 * 面试题5：替换空格
 * 请实现一个函数，把字符串中的每个空格替换成"20%"。
 * "we are happy. " -> "we%20are%20happy."
 */
public class Test5StringReplaceblank {
    public static String replaceblank(String str){
        if (str == null || str.length()==0){
            return str;
        }
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                count ++;
            }
        }
        if(count ==0){
            return str;
        }
        int length = str.length() + 2 * count;
        char[] temp = new char[length];
        for (int i = str.length()-1; i >=0 ; i--) {
            if(str.charAt(i) == ' '){
                temp[length-3] = '%';
                temp[length-2] = '2';
                temp[length-1] = '0';
                length = length - 3;
            }else {
                temp[length-1] = str.charAt(i);
                length --;
            }
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        String str = "we are happy.";
        String str1 = "abc";
        String replaceblank = replaceblank(str1);
        System.out.println(replaceblank);
    }
}
