package com.cpq.code;

public class Test4TwodimensionalArray {
    /**
     * 面试题4： 二维数组中的查找
     * <p>
     * 在一个二维数组中。每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否有该整数
     */
    public static boolean findnum(int[][] arr, int t) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                if (t == arr[i][j])
                    return true;
        }
        return false;
    }

    public static boolean findnum2(int[][] arr, int t) {
        int line = 0;
        int row = arr[line].length - 1;

        while (line <arr.length && row >=0) {
            if (t == arr[line][row])
                return true;
            else if (t > arr[line][row]) {
                line++;

            } else {
                row--;
            }
        }


        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9, 10},
                {2, 4, 9, 12, 16},
                {4, 7, 10, 13, 19},
                {6, 8, 11, 15, 20}
        };
        System.out.println(matrix.length + "  " + matrix[1].length);
        System.out.println(findnum2(matrix, 7));    // 要查找的数在数组中
        System.out.println(findnum2(matrix, 5));    // 要查找的数不在数组中
        System.out.println(findnum2(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(findnum2(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(findnum2(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(findnum2(matrix, 16));   // 要查找的数比数组中最大的数字还大
//        System.out.println(findnum2(null, 16));     // 健壮性测试，输入空指针
    }
}
