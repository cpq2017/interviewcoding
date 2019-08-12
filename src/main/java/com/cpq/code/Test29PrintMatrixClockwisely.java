package com.cpq.code;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
//==================================================================

// 面试题29：顺时针打印矩阵
// 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
public class Test29PrintMatrixClockwisely {
    public void PrintMatrixClockwisely(int[][] numbers, int cols, int rows) {
        if (numbers == null || cols <= 0 || rows <=0)
            return;
        int start = 0;
        while (cols > start *2 && rows > start *2) {
            PrintMatrixInCircle(numbers,cols,rows,start);
            ++ start;
        }

    }

    private void PrintMatrixInCircle(int[][] numbers, int cols, int rows,int start) {
        int endX = cols -1 -start;
        int endY = rows -1 -start;

        // 从左往右打印
        for (int i = start; i<= endX; ++i){
           int number = numbers[start][i];
            System.out.printf("%d\t", number);
        }

        //从上到下
        if (start< endY) {
            for (int i = start+1; i <=endY ; ++i) {
                System.out.printf("%d\t", numbers[i][endX]);
            }
        }

        //从右往左打印
        if (start < endX && start< endY){
            for (int i = endX -1; i >= start ; --i) {
                System.out.printf("%d\t", numbers[endY][i]);
            }
        }
        //从下往上
        if (start< endX && start < endY-1){
            for (int i = endY-1; i >= start+1 ; --i) {
                System.out.printf("%d\t", numbers[i][start]);
            }
        }
    }

    // ====================测试代码====================
    public void Test(int columns, int rows)
    {
        System.out.printf("Test Begin: %d columns, %d rows.\n", columns, rows);

        if(columns < 1 || rows < 1)
            return;

        int[][] numbers = new int[rows][rows];
        for(int i = 0; i < rows; ++i)
        {
            numbers[i] = new int[columns];
            for(int j = 0; j < columns; ++j)
            {
                numbers[i][j] = i * columns + j + 1;
            }
        }

        PrintMatrixClockwisely(numbers, columns, rows);
        System.out.printf("\n");

    }

    public static void main(String[] args) {
        final Test29PrintMatrixClockwisely test29 = new Test29PrintMatrixClockwisely();
  /*
    1    2
    3    4
    5    6
    7    8
    9    10
    */
        test29.Test(5,2);
    }
}
