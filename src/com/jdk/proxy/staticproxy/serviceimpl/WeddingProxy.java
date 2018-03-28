package com.jdk.proxy.staticproxy.serviceimpl;

import com.jdk.proxy.staticproxy.service.Marry;

/**
 * Created by Administrator on 2018/1/26.
 */
public class WeddingProxy implements Marry {

    private Marry xiaoyu;

    public WeddingProxy(Marry xiaoyu){
        this.xiaoyu = xiaoyu ;
    }

    private void before(){
        System.out.println("布置婚房。。。。");
    }
    private void after(){
        System.out.println("闹洞房。。。。");
    }
    @Override
    public void marry() {
           before();
           xiaoyu.marry();
           after();
    }
}
