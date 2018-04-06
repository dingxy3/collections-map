package com.jdk.decoratorpattern.serviceImpl;

import com.jdk.decoratorpattern.service.Shape;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/1
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
         System.out.println("我是圆形");
    }
}
