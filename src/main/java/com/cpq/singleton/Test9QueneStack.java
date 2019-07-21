package com.cpq.singleton;

import java.util.LinkedList;
import java.util.Queue;

public class Test9QueneStack {
    private static Queue<Integer> q1 = new LinkedList<>();
    private static Queue<Integer> q2 = new LinkedList<>();

    public void push(int num) {
        if (q2.isEmpty()) {
            q1.add(num);
        } else {
            q2.add(num);
        }

    }

    public int pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new RuntimeException("null stack");
        } else if (!q1.isEmpty()) {
            int size = q1.size() - 1;
            for (int i = 0; i < size; i++) {
                q2.add(q1.remove());
            }
            return q1.remove();
        } else {
            int size = q2.size() - 1;

            for (int i = 0; i < size; i++) {
                q1.add(q2.remove());
            }

            return q2.remove();
        }

    }

    public void printlnStack() {
        if (!q1.isEmpty()) {
            System.out.println("q1 =  " + q1.toString());
        } else
            System.out.println("q2 =  " + q2.toString());
    }

    public static void main(String[] args) throws Exception {
        Test9QueneStack test9QueneStack = new Test9QueneStack();
        for (int i = 0; i < 10; i++) {
            test9QueneStack.push(i);
        }
        test9QueneStack.printlnStack();

        for (int i = 0; i < 5; i++) {
            System.out.println("del " + test9QueneStack.pop());
            Thread.sleep(1000);
        }
        test9QueneStack.printlnStack();
    }

}
