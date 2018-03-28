package com.jdk.observer;

import com.jdk.observer.service.Observer;
import com.jdk.observer.service.ObserverAble;
import com.jdk.observer.serviceimpl.ObserverAbleImpl;
import com.jdk.observer.serviceimpl.UserImpl;

/**
 * Created by Administrator on 2018/1/26.
 */
public class Test  {
    public static void main(String[] args) {
        Observer o = new UserImpl("马云");
        Observer o1 = new UserImpl("刘强东");
        ObserverAbleImpl ob = new ObserverAbleImpl();

        ob.registerObserver(o);
        ob.registerObserver(o1);
        ob.setInfomation("小雨和梓颖要结婚了");

    }
}
