package com.jdk.thread;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/19
 **/
public class TestRun extends Thread {

    public static void main(String[] args) {
        MyService myService = new MyService();
        for (int i = 0; i < 2; i++) {
            ThreadBB output = new ThreadBB(myService);
            output.start();
            ThreadAA input = new ThreadAA(myService);
            input.start();
            ThreadCC threadCC = new ThreadCC(myService);
            threadCC.start();
        }
      System.out.println("是否改变"+myService.orderNum);
    }

}
class ThreadBB extends Thread {

    private MyService dbtools;

    public ThreadBB(MyService dbtools) {
        super();
        this.dbtools = dbtools;
    }

    @Override
    public void run() {
        dbtools.methodB();
    }

}
class ThreadCC extends Thread {

    private MyService dbtools;

    public ThreadCC(MyService dbtools) {
        this.dbtools = dbtools;
    }

    @Override
    public void run() {
        dbtools.methodC();
    }

}
class ThreadAA extends  Thread{

    private MyService dbtools;

    public ThreadAA(MyService dbtools) {
        super();
        this.dbtools = dbtools;
    }

    @Override
    public void run() {
        dbtools.methodA();
    }
}


