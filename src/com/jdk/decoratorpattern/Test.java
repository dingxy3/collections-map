package com.jdk.decoratorpattern;

import com.jdk.decoratorpattern.service.Shape;
import com.jdk.decoratorpattern.serviceImpl.Circle;
import com.jdk.decoratorpattern.serviceImpl.RedShapeDecorator;

/**
 * @param
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/4/1
 **/
public class Test {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();
    }
}
