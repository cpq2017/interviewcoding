package com.cpq.code;

/**
 * 面试题10： 斐波那契数列
 *
 * 求斐波那契数列的第n项
 * 写一个函数，输入n，求斐波那契数列的第n项
 *
 *         0     n=0;
 * f(n) =  1     n=1;
 *         f(n-1)+f(n-2) n>1;
 */
public class Test10Fibonacci {

    public long fibonacci(int num) {
        /**
         * 时间复杂度：O(2^n)
         */
        if (num ==0)
            return 0;
        if(num == 1)
            return 1;
        return fibonacci(num-1)+fibonacci(num-2);
    }
    public long fibonacci2(int num ){
        /**
         * 时间复杂度：O(n)
         */
        if (num ==0)
            return 0;
        if(num == 1)
            return 1;
        long fibmaxnum = 1;
        long fibmixnum = 0;
        long result =0;
        for (int i=2;i<= num;++i){
            result = fibmaxnum+fibmixnum;
            fibmixnum = fibmaxnum;
            fibmaxnum = result;

        }
        return result;

    }

    public static void main(String[] args) throws Exception{
        Test10Fibonacci test10Fibonacci = new Test10Fibonacci();
        long start = System.currentTimeMillis();
        System.out.println(start);
        long fibonacci = test10Fibonacci.fibonacci(40);
        System.out.println(fibonacci);
        System.out.println(System.currentTimeMillis());

        long l = test10Fibonacci.fibonacci2(40);
//        Thread.sleep(1000);
        System.out.println(l);

        System.out.println(System.currentTimeMillis());
    }

}
