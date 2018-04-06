package com.jdk.proxy.staticproxy;

import com.jdk.proxy.dynamicproxy.TestDynamicProxy;
import com.jdk.proxy.staticproxy.service.Marry;
import com.jdk.proxy.staticproxy.staticpoxy.WeddingProxy;
import com.jdk.proxy.staticproxy.serviceimpl.XiaoyuMarry;

/**
 * Created by Administrator on 2018/1/26.
 *   静态代理 设计模式
 * 1、真实角色
 * 2、代理角色： 持有真实角色的引用
 * 3、二者 实现相同的接口
 */
public class StaticProxy {

    public static void main(String[] args) {

       /* //创建真实角色
        Marry xiaoyu = new XiaoyuMarry();
        //创建代理角色 +把真实角色赋给代理类角色
        Marry wed = new WeddingProxy(xiaoyu);

        wed.marry();*/
        Marry marry = new XiaoyuMarry();
        TestDynamicProxy test = new TestDynamicProxy(marry);
        Marry m = (Marry) test.testDynamic();
        m.marry();

    }

}
