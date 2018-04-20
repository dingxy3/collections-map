package com.jdk.thread;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/19
 **/
class T11 extends Thread {
    @Override
    public void run() {
        System.out.println("in T1");
    }
}

class T22 extends Thread {
    @Override
    public void run() {
        System.out.println("in T2");
    }
}

class T33 extends Thread {
    @Override
    public void run() {
        System.out.println("in T3");
    }
}

public class TestJoin2 {
    public static void main(String[] args) throws InterruptedException {
        T11 t1 = new T11();
        T22 t2 = new T22();
        T33 t3 = new T33();

        t1.start();
        t1.join();

        t2.start();
        t2.join();
        t3.start();











    }
}