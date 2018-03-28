package com.jdk.thread;


/**
 * Created by Administrator on 2018/1/23.
 */
public class TestThread {
    public static void main(String[] args) {
        System.out.println("主线程Id'"+Thread.currentThread().getId());

        Mythread t1 = new Mythread("t1");
        t1.start();//会创建新的线程
        Mythread t2 = new Mythread("t2");
        t2.run();//不会创建新的线程，直接在主线程上调用

    }
}
