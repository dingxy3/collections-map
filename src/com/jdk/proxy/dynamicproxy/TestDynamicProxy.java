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
public class TestDynamicProxy implements InvocationHandler{

   private Object target;

    public TestDynamicProxy(Object target) {
        super();
        this.target = target;
    }

    public Object testDynamic() {

       return  Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(target, args);

    }
    }
