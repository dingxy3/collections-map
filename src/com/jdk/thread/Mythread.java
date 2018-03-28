package com.jdk.thread;

/**
 *
 * @author Administrator
 * @date 2018/1/23
 */
public class Mythread extends Thread {

    private static int num = 0;
    public Mythread(){
        num ++;
    }
    private String name;

    public Mythread(String name){
        this.name = name;
        num++;
    }

    @Override
    public void run(){
            System.out.println("主动创建第:"+num+"线程");
            System.out.println("子线程name:=="+name+":::::"+Thread.currentThread().getId());
    }

}
