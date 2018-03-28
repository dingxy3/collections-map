package com.jdk.observer.serviceimpl;

import com.jdk.observer.service.Observer;
import com.jdk.observer.service.ObserverAble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 * 监听者实现类
 */
public class ObserverAbleImpl implements ObserverAble {

    /*private List<Observer> list = new ArrayList<>();需要初始化*/

    private List<Observer> list ;

    private String message ;

    //初始化
    public ObserverAbleImpl() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {

        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
          list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer l:list) {
            Observer o2 = l;
            l.update(message);
        }

    }
    public void setInfomation(String s){
          this.message = s;
          System.out.println("喜报： " + s);
          notifyObserver();
    }
}
