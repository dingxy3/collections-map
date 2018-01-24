package com.jdk;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Administrator on 2017/11/14.
 */
public class ImplHashMap<K,V>  extends AbstractMap<K,V>
        implements Map<K,V>, Cloneable, Serializable {


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    static class Node<K,V> implements Map.Entry<K,V> {
        int hash;
        V value;
        K key;
        Node<K, V> next;


        Node(int hash, K key, V value, Node<K, V> next) {

            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;

        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
             V oldValue = value;
             this.value= value;
             return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }
        @Override
        public final String toString(){return key+"="+value;}

        @Override
        public final int hashCode() {
                  int keyHash = (key!=null?key.hashCode():0);
                  int valueHash = (value!=null?value.hashCode():0);

            return keyHash ^ keyHash;//取异或
        }

        static final int hash(Object key) {
            int h;
            //key.hashCode()低位 ；h >>> 16高位
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }


        transient ImplHashMap.Node<K, V>[] table;

        //get方法
        public V get(Object key) {
            Node<K, V> e;

            return null;
        }


    }
}



