package com.jdk.strategy.serviceImpl;

import com.jdk.strategy.service.Cards;

import javax.jws.WebService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/7
 **/
public class CreatCards extends Cards {


    @Override
    protected void execute(int cents) {
        System.out.println("储蓄卡支付====="+cents);
    }

    @Override
    protected String getType() {
        return "creat";
    }
}
