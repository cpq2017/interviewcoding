package com.cpq.code;

public class Test2SingletonTest {
    public static class Singleton {
        /**
         * 单例模式，饿汉式，线程不安全
         */
    private Singleton (){}
        private static Singleton  instance = null;
        public static Singleton getInstance() {
            if (instance == null)
                instance = new Singleton();
            return instance;
        }
    }
    public  static class  Singleton2 {
        /**
         * 单例模式，懒汉式，线程安全
         */
        private Singleton2 (){}
        private final static Singleton2 instance = new Singleton2();
        public static Singleton2 getInstance() {
            return instance;
        }
    }
    /**
     * 单例模式，饿汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3 {
        private Singleton3 (){}
        private static Singleton3 instance = null;
        public static  synchronized Singleton3 getInstance() {
            if (instance == null)
                instance = new Singleton3();
            return  instance;
        }

    }
    /**
     * 单例模式，饿汉式，变种，线程安全
     */
    public static class Singleton5 {
        private Singleton5() {
        }
        private static Singleton5 instance = null;
        static {
            instance = new Singleton5();
        }
        public static Singleton5 getInstance(){
            return  instance;
        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton4 {
        private Singleton4 (){}
        private static Singleton4 instance = null;
        public static   Singleton4 getInstance() {
            if (instance == null){
                synchronized (Singleton4.class) {
                    if (instance == null)
                    instance = new Singleton4();
                }
            }
            return  instance;
        }

    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐】
     */

    public static class Singleton6 {
        private final static class  initSingleton{
            private final static Singleton6 init =  new Singleton6();
        }
        private Singleton6(){}
        public static Singleton6 getInstance(){
            return initSingleton.init;
        }
    }
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());

    }

}
