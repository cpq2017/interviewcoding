package com.cpq.code;

/**
 * 面试题11 ： 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组的一个旋转
 * 输出旋转数组的最小元素。
 * 例如： 数组{3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，
 * 该数组的最小值为1
 */
public class Test11Min {
    public int findmin(int[] arr) {
        // 未考虑特殊情况
        int start = 0;
        int mid = start;
        int end = arr.length - 1;
        while (arr[start] >= arr[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (arr[mid] >= arr[start]) {
                start = mid;

            } else if (arr[mid] <= arr[end])
                end = mid;
        }
        return arr[mid];
    }

    public int findmin2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start;
        while (arr[start] >= arr[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            // 特殊情况：start、end和mid 指向的三个数字相等，则只能顺序查找
            if (arr[start] == arr[end] &&
                    arr[start] == arr[mid])
                return MinInOrder(arr, start, end);

            if (arr[mid] >= arr[start]) {
                start = mid;
            } else if (arr[mid] <= arr[end]) {
                end = mid;
            }
        }
        return arr[mid];
    }

    public int MinInOrder(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }

        }
        return result;
    }

    public static void main(String[] args) {


//        1
//        2 1
//        3 1
//        4 1
//        5 1

//        1
//        2 1
//        3 1
//        4 0
//        5 1
//        6 2
        Test11Min test11Min = new Test11Min();
//        （1）典型输入，单调升序的数组的一个旋转
        int[] arr = {3, 4, 5, 6, 1, 2};
        int findmin = test11Min.findmin2(arr);
        System.out.println(findmin);
//        （2）有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(2 +" "+test11Min.findmin2(array2));
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = { 3, 4, 5, 1, 2, 2 };
        System.out.println(3 +" "+test11Min.findmin2(array3));
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = { 1, 0, 1, 1, 1 };
        System.out.println(4 +" "+test11Min.findmin2(array4));
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = { 1, 2, 3, 4, 5 };
        System.out.println(5 +" "+test11Min.findmin2(array5));
        // 数组中只有一个数字
        int[] array6 = { 2 };
        System.out.println(6 +" "+test11Min.findmin2(array6));
    }
}
