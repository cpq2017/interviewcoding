package com.cpq.code;

import java.util.Scanner;

/**
 * 回溯算法
 * 面试题13：机器人的运动范围
 *  地上有m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，
 *  它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标
 *  的数位之和大于k的格子。
 *  例如： 当k=18时，机器人能够进入方格（35，37），因为
 *  3+5+3+7 = 18。但它不能进入方格（35，38），因为
 *  3+5+3+8 = 19
 *  请问机器人能够到达多少个格子？
 *
 */
public class Test13MovingCount {
    public int movingCount(int threshold,int rows,int cols){
        if (threshold <0 || rows<=0 || cols <=0)
            return 0;
        boolean[] visited = new boolean[rows*cols];
        for (int i = 0; i < rows; i++) {
            visited[i] = false;
        }
        int count = movingCountCore(threshold,rows,cols,0,0,visited);

        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols,
                                int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row*cols +col]  = true;
            count = 1+movingCountCore(threshold,rows,cols,row-1,col,visited)
                    +movingCountCore(threshold,rows,cols,row,col-1,visited)
                    +movingCountCore(threshold,rows,cols,row+1,col,visited)
                    +movingCountCore(threshold,rows,cols,row,col+1,visited);
        }
        return count;
    }
    private boolean check(int threshold, int rows, int cols,
                          int row, int col, boolean[] visited){

        if (row >=0 && row <rows && col >= 0 && col  < cols
                && getDigitSum(row) +getDigitSum(col) <= threshold
        && !visited[row*cols+col]){
            return  true;

        }
        return false;

    }
    private int getDigitSum(int num){
        int sum = 0;
        while (num >0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入限制条件k:");
        int k = scanner.nextInt();
        System.out.println("请输入方格的行数m：");
        int m = scanner.nextInt();
        System.out.println("请输入方格的列数n:");
        int n = scanner.nextInt();

        Test13MovingCount solution1 = new Test13MovingCount();

        scanner.close();
        System.out.println("矩阵能到达的方格数是：");
        System.out.println(solution1.movingCount(k, m, n));
    }




}
