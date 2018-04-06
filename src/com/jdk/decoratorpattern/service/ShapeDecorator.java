package com.jdk.decoratorpattern.service;

/**
 * @Author: dingxy3
 * @Description:装饰者
 * @Date: Created in  2018/4/1
 **/
public abstract  class ShapeDecorator implements Shape {

    protected Shape shape;

    public  ShapeDecorator(Shape shape ){
           this.shape = shape;
    }
}
