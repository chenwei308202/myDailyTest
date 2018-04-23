package com.cw.demo.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 红黑树 实现
 * Created by chenwei01 on 2018/4/20.
 */
public class RedBlackTree<K,V> {

    /**
     *集合数量
     */
    private int size;

    private Entry<K,V> root;


    public V get(K k){

        return  getEntry(k)==null?null:getEntry(k).value;
    }

    public  Entry<K,V> getEntry(K k){
        if (k==null){
            throw  new IllegalArgumentException("key is null");
        }
        Entry<K,V> t= root;
        int i=0;
        while (t!=null){
            i= ((Comparable)k).compareTo(t.key);
            if (i>0){
                t= t.right;
            }else if(i<0) {
                t=t.left;
            }else {
                return t;
            }
        }
        return null;
    }

    public V put(K k,V v){
        if (k==null){
            throw  new IllegalArgumentException("key is null");
        }
        Entry<K,V> t=root;
        if (t == null) {
            root=new Entry(k,v,null);
            size++;
            return null;
        }
        int i=0;
        Entry<K,V> parent=null;
        while (t!=null) {
             parent=t;
            i= ((Comparable)k).compareTo(t.key);
            if (i>0){
                t= t.right;
            }else if(i<0) {
                t=t.left;
            }else {
                V oldValue=t.value;
                t.value=v;
                return oldValue;
            }
        }
        t= new Entry(k,v,parent);
        if(i>0){
            parent.right=t;
        }else {
            parent.left=t;
        }
        size++;
        return null;
    }

    public void putAll(Map<K,V> map){
        if (map!=null && map.size()!=0){
            Set<Map.Entry<K, V>> entries =map.entrySet();
            Iterator<Map.Entry<K, V>> iterator = entries.iterator();
            Map.Entry<K, V> next=null;
            while (iterator.hasNext()){
                next = iterator.next();
                put(next.getKey(),next.getValue());
            }
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree=new RedBlackTree();
        Map map = new HashMap();
        map.put("123","345");
        map.put("sf","df");
        map.put("sdfa","sdf");
        map.put("23", "dfs");
        tree.putAll(map);
        System.out.println(tree.size);
        System.out.println(tree.get("sf"));
    }


    static final class Entry<K,V>{

        public Entry(K key, V value,Entry<K,V> parent) {
            this.key = key;
            this.value = value;
            this.parent=parent;
        }

        Entry parent;

         Entry left;

         Entry right;

         V value;

         K key;
    }

}
