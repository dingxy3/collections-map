package com.jdk.observer.service;

/**
 * Created by Administrator on 2018/1/26.
 * 被观察者（监听者）
 */
public interface ObserverAble {

    //添加
    void registerObserver(Observer o);

    //删除
    void removeObserver(Observer o);

    //通知
    void notifyObserver();
}
