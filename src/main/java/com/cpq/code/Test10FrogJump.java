package com.cpq.code;

/**
 * 面试题10：
 *  青蛙跳台阶问题
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 *  求青蛙跳上一个n级台阶总共有多少种条法
 *
 *  1、初级版
 * 一只青蛙跳台阶，一次可以跳1阶，可以2阶。那么，台阶为n时，有多少种跳法。
 *
 * 2、升级版
 * 一只青蛙跳台阶，一次可以跳1阶，可以2阶，其能力足够强大以至于一次可以跳n阶。那么，台阶为n时，有多少种跳法。
 */
public class Test10FrogJump {
    /**
     *  1、第一种情况（初级版）
     * 一次只能挑一阶或者两阶时。如果只有1阶，那么一共有1种跳法；
     * 如果有2阶，那么一共有2种跳法。如果有n阶时，最后一步青蛙只能从第n-1或者n-2这两种情况往上跳。
     * 那么，假设n阶时有f(n)种跳法，由上可知：
     */
    private int qingwa(int a) {
        if (a == 1) {
            return 1;
        } else if (a == 2) {
            return 2;
        } else {
            return qingwa(a - 1) + qingwa(a - 2);
        }
    }

    /**
     * 第二种情况（升级版）
     * 升级版的青蛙具有超凡的能力，问题也更加复杂。
     * 假设一共有n阶，同样共有f(n)种跳法，那么这种情况就比较多，
     * 最后一步超级蛙可以从n-1阶往上跳，也可以n-2阶，也可以n-3…等等等，以次类推。
     * 所以,可知：
     *
     * 式1：
     * f(n) = f(n-1) + f(n-2) + ... + f(2) + f(1)
     * 而且，容易得出：
     *
     * 式2：
     * f(n-1) = f(n-2) + f(n-3) + ... + f(2) + f(1)

     * 将式1中的f(n-2) + f(n-3) + … + f(2) + f(1) 替换成式2，可知：
     *
     * f(n) = f(n-1) + f(n-1) = 2 * f(n-1)
     *
     * @param num
     */
    public int qingwa2(int num){
        if(num == 1){
            return 1;
        }else if (num == 2){
            return 2;

        }else {
            return 2*qingwa2(num-1);
        }
    }

    public static void main(String[] args) {
        Test10FrogJump test10FrogJump = new Test10FrogJump();
        int qingwa = test10FrogJump.qingwa(5);
        System.out.println(qingwa);
        int i = test10FrogJump.qingwa2(5);
        System.out.println(i);
    }


}
