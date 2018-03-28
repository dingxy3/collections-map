package com.jdk.thread;

/**
 * Created by Administrator on 2018/1/23.
 */
public class TestRunable  {
    public static void main(String[] args) {
        MyRunable r = new MyRunable();
        Thread t = new Thread(r);
        t.start();
    }

}
class MyRunable implements Runnable{

    @Override
    public void run() {
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }
}