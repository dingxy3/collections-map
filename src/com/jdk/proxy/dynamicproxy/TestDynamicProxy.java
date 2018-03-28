package com.jdk.proxy.dynamicproxy;

import com.jdk.proxy.staticproxy.service.Marry;
import com.jdk.proxy.staticproxy.serviceimpl.XiaoyuMarry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: dingxy3
 * @Description:
 * @Date: Created in  2018/3/28
 */
public class TestDynamicProxy implements InvocationHandler  {

    private Object o;

    public Object testDynamic(Object o,Class interfaces){


       /* o = Proxy.newProxyInstance(o.getClass().getClassLoader(),new Class[]{o.getClass()},new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(new XiaoyuMarry(),args);
            }
        });

        return o;*/
       this.o = o;
       return  Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(o, args);
    }
}
