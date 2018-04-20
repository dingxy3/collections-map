package com.jdk.thread.threadlocal;

import java.util.Random;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/19
 **/
public class ThreadScopShareData {
    private static int data = 0;//我们定义一个静态变量data

    static class A{//定义一个静态内部类
        public void getData(){
            System.out.println(Thread.currentThread().getName()+"从A中得到数据"+data);
        }
    }

    static class B{//定义第二个静态内部类
        public void getData(){
            System.out.println(Thread.currentThread().getName()+"从B中得到数据"+data);
        }
    }

    public static void main(String[] args) {
        //在主函数中创建两个线程
        for(int i=1;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data =new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+"已经设置了数据"+data);
                    new A().getData();
                    new B().getData();
                }
            }).start();

        }
    }
}
