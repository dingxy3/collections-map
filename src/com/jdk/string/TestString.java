package com.jdk.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @Author: dingxy3
 * @Description:测试String相关
 * @Date: Created in  2018/5/8
 **/
public class TestString {

    /**
     * 均指向常量池中对象。
     */
    public static void test(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("test()==" + (s1 == s2));

    }

    /**
     * false，两个引用指向堆中的不同对象。
     */
    public static void test2(){
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("test()2 ==" + (s1 == s2));

    }

    /**
     * false，因为s2+s3实际上是使用StringBuilder.append来完成，会生成不同的对象。
     */
    public static void test3(){

        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println("test3() ==" +(s1 == s4));
    }

    /**
     *true，因为final变量在编译后会直接替换成对应的值，
     * 所以实际上等于s4=”a”+”bc”，而这种情况下，编译器会直接合并为s4=”abc”，所以最终s1==s4。
     */
    public static void test4(){


        String s1 = "abc";
        final String s2 = "a";
        final String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println("test4===" + (s1 == s4));

    }

    /**
     * false，false，true。
     */
    public  static  void  test5(){

        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
    }

    public static void main(String[] args) {
        test();
        test2();
        test3();
        test4();
       // test5();
        List list =new ArrayList();
        if (null != list && list.size()>0) {
            list.get(0);
        }


    }

}
