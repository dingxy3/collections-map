
package com.jdk.thread;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/18
 **/
public class VolatileTest {

    private  static volatile boolean run = true;
    //private  static  boolean run = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t=   new Thread(()->{
            int i =0;
            while (run){
               i++;
            }
        });
        t.start();

        Thread.sleep(1000);
        System.out.println("stop");
        run=false;
        System.out.println(run);
    }

}
