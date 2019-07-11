package com.cpq.singleton;

/**
 * 数组中重复的数字
 * 一、找出数字组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0～n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数组重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如：如果输入长度为7的数组（2，3，1，0，2，5，3），
 * 那么对应输出是重复的数字2 或者3。
 *
 */
public class Test3Array {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,4,5,6};
//        int repeatNum = getRepeatNum(arr);
//        System.out.println(repeatNum);
        int repeatNum2 = getRepeatNum2(arr);
        System.out.println(repeatNum2);

    }
    public static int getRepeatNum(int[] arr){
        /**
         * 一、找出数字组中重复的数字
         *  在一个长度为n的数组里的所有数字都在0～n-1的范围内。
         *  数组中某些数字是重复的，但不知道有几个数组重复了，也不知道每个数字重复了几次。
         *  请找出数组中任意一个重复的数字。
         *  例如：如果输入长度为7的数组（2，3，1，0，2，5，3），
         *  那么对应输出是重复的数字2 或者3。
         *
         *
         */
        if (arr == null || arr.length<=0){
            System.out.println("数组为空");
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <0 || arr[i] > arr.length-1){
                System.out.println("数组中元素不符合要求！");
                return -1;
            }
        }
        for (int j = 0; j < arr.length ; j++) {
            int temp;
            while (arr[j] != j){
                System.out.println(" whilt arr"+ j);
                if(arr[j] == arr[arr[j]]){

                    return arr[j];
                }
                temp= arr[j];
                System.out.println(" if temp "+ temp);
                arr[j] = arr[temp];
                System.out.println(" if  arr[j] "+ arr[j] );
                arr[temp] = temp;
                System.out.println(" if arr[temp] "+ arr[temp]  );
            }
        }
        return  -1;
    }
    /**
     *  二、不修改数组找出重复的数字
     *  一个长度为n+1的数组里的所有数字都在1～n的范围内。
     *  所以至少有一个重复数字，找出任意一个
     *  不能修改输入的数组
     */
    public static int getRepeatNum2 (int[] arr) {
     int start = 1;
     int end = arr.length-1;
        int middle,count;
     while (end>= start){
          middle = (end-start)/2 +start;
          count = count(arr, start, middle);
         if(end == start) {
             if(count >1){
                 return start;
             }
             else
                 break;
         }
         if(count> (middle-start+1)){
             end = middle;
         }else
             start = middle+1;

     }
        return  -1;
    }
    static int count(int[] arr,int start,int end){
        if(arr == null){
            return -1;
        }
        int count =0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] >= start && arr[i]<=end){
                ++count;
            }
        }
        return count;
    }

}
