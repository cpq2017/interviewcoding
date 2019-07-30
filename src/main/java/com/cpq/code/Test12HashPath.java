package com.cpq.code;



/**
 * 面试题12：矩阵中的路径
 * 设计一个函数，用来判断在一个矩阵中是否存在一条包含某
 * 字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向
 * 左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么
 * 该路径不能再次进入该格子。例如，下面的3*4 矩阵中包含一条字符串
 * "bfce" 的路径。但矩阵中不包含字符串"abfb" 的路径，因为字符串
 * 的第一个字符b占据了矩阵中第一行第二个格子之后，路径不能再次进入该格子
 *
 *  a   b   t   g
 *  c   f   c   s
 *  j   d   e   h
 *
 *
 * 思路
 * 　　首先对所整个矩阵遍历，找到第一个字符，然后向上下左右查找下一个字符，
 * 由于每个字符都是相同的判断方法（先判断当前字符是否相等，再向四周查找），
 * 因此采用递归函数。由于字符查找过后不能重复进入，所以还要定义一个与字符矩阵大小相同的布尔值矩阵，
 * 进入过的格子标记为true。如果不满足的情况下，需要进行回溯，
 * 此时，要将当前位置的布尔值标记回false。（所谓的回溯无非就是对使用过的字符进行标记和处理后的去标记）
 *
 * 测试用例
 *
 * 　　1.功能测试（多行多列矩阵中存在或者不存在路径）
 *
 * 　　2.边界值测试（矩阵只有一行；矩阵与路径的所有字符都相同）
 *
 * 　　3.特殊输入测试（null）
 */
public class Test12HashPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] isVisited = new boolean[rows * cols];
        for (boolean v : isVisited) {
            v = false;
        }
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                                boolean[] isVisited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row * cols + col] == true
                || str[pathLength] != matrix[row * cols + col])
            return false;
        if (pathLength == str.length - 1)
            return true;
        boolean hasPath = false;
        isVisited[row * cols + col] = true;
        hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);

        if (!hasPath) {
            isVisited[row * cols + col] = false;
        }
        return hasPath;
    }

    // =======测试代码========

    // A B T G
    // C F C S
    // J D E H

    // BFCTB
    public void test1() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCTB".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test1 passed.");
        else
            System.out.println("Test1 failed.");
    }

    // A B T G
    // C F C S
    // J D E H

    // BFCE
    public void test2() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCE".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test2 passed.");
        else
            System.out.println("Test2 failed.");
    }

    // matrix=null
    public void test3() {
        char[] matrix = null;
        int rows = 0;
        int cols = 0;
        char[] str = "BFCE".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test3 passed.");
        else
            System.out.println("Test3 failed.");
    }

    // str=null
    public void test4() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = null;
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test4 passed.");
        else
            System.out.println("Test4 failed.");
    }

    // A

    // A
    public void test5() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "A".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test5 passed.");
        else
            System.out.println("Test5 failed.");
    }

    // A

    // B
    public void test6() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "B".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test6 passed.");
        else
            System.out.println("Test6 failed.");
    }

    // AAAA
    // AAAA
    // AAAA

    // AAAAAAAAAAAA
    public void test7() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "AAAAAAAAAAAA".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test7 passed.");
        else
            System.out.println("Test7 failed.");
    }


    public static void main(String[] args) {
        Test12HashPath demo = new Test12HashPath();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }


    /**
     * 收获
     *  　　1.回溯法用于多个步骤，每个步骤有多个选项的问题：若当前步骤满足条件，
     *  给定一个标记，当发现之后的步骤不满足条件时，去除标记。
     *
     * 　　2.字符串转为字符数组，使用toCharArray()方法
     *
     * 　　3.二维数组下标的计算：row*cols+col，小心别搞错。
     */
}
