package com.jdk.decoratorpattern.serviceImpl;

import com.jdk.decoratorpattern.service.Shape;
import com.jdk.decoratorpattern.service.ShapeDecorator;

import java.lang.reflect.Method;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/1
 **/
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }
    private void setRedBorder(Shape decoratedShape){
        System.out.println("我给"+decoratedShape.getClass()+"装备的颜色是: 红色");
    }
}
