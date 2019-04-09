package com.jdk.strategy.service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/6
 **/
 public  abstract class Cards implements Pay{


   public static Map<String,Object> map = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        map.put(getType(),this);
    }

    @Override
    public void pay(int cents) {
        execute(cents);
    }

    protected abstract void execute(int cents);

    protected abstract String getType();
}
