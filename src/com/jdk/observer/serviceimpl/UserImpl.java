package com.jdk.observer.serviceimpl;

import com.jdk.observer.service.Observer;

/**
 * Created by Administrator on 2018/1/26.
 * 实现观察者
 */
public class UserImpl implements Observer {

    private String message;

    private String name;

    public UserImpl(String name){
        this.name = name ;
    }

    @Override
    public void update(String message) {

        System.out.println(name+"收到推送喜报  ： "+message);
    }
}
