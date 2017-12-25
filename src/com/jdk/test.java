package com.jdk;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/12/18.
 */
public class test {

    public static void main(String[] args) {

        //implArrayList
       /* ImplArrayList list = new ImplArrayList<>();

        list.add("1");
        list.add("2");
        System.out.println(list.contains("2"));
        System.out.println(list.indexOf("2"));
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.isEmpty());
        System.out.println(list.remove("2"));
        System.out.println(list.contains("2"));
        System.out.println("list的长度"+list.size());*/


        //string a = "abc" string b = "abc"
        // string c = new string("abc") string d = "ab"+"c"他们之间等于比较结果
      /*  String a = "abc" ;
        String b = "abc" ;
        String c = new String("abc") ;
        String d = "ab" +"c" ;

        System.out.println("---------------");
        System.out.println("a==b:"+a==b);//false
        System.out.println(a==b);//true
        System.out.println(a==b?"1":"2");//1
        System.out.println(a==c);//false
        System.out.println(a==d);//true
        System.out.println("---------------");*/

        //++cur 和cur++
       /* int cur = 0 ;
        System.out.println(cur++); //0
        int next = 0 ;
        System.out.println(++next);//1*/
    /*    int[] arr = {1,2,3,4};
        int[] arr1 = {5,6,7};
        System.arraycopy(arr,0,arr1,2,1);
        System.out.println(arr);
        System.out.println(arr1);//{5,6,1}*/
        ImplArrayList list = new ImplArrayList<>();
        list.add("1");
        list.add("2") ;
        list.add("3") ;
        Iterator it = list.iterator();
        while (it.hasNext()){
            String a =  it.next().toString();
            System.out.println(a);
        }

    }
}
