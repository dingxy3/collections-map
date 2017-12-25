package com.jdk;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/11/14.
 */
public class ImplHashMap {

    static class Node<K,V> implements Map.Entry<K,V> {
        int hash;
        V value;
        K key;
        Node<K, V> next;


        Node(int hash, K key, V value, Node<K, V> next) {

            this.hash = hash;
            this.key = key;
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
            return null;
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

        transient ImplHashMap.Node<K, V>[] table;

        //get方法
        public V get(Object key) {
            Node<K, V> e;

            return null;
        }

        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }
    }
}



