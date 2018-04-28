package com.cw.demo.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树 实现
 * Created by chenwei01 on 2018/4/20.
 */
public class Tree<K,V> {

    /**
     *集合数量
     */
    private int size;

    private Entry<K,V> root;


    public V get(K k){

        return  getEntry(k)==null?null:getEntry(k).value;
    }

    public V remove(K k) {
        Entry<K,V> temp= getEntry(k);
        if (temp == null) {
            return null;
        }
        V value=temp.value;
        deleteEntry(temp);
        return value;
    }

    Entry<K,V> getEntry(K k){
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

    Entry<K,V> deleteEntry(Entry<K, V> entry) {
        Entry<K, V> t=entry;
        if (t != null) {
            Entry<K, V> target=null;
            //如果将要移除的节点不是叶子节点，则找出后继节点
            if (t.left!=null || t.right!=null){
                if (t.right!=null){
                    //则后继节点为右侧最左边的孩子节点
                    target=  t.right;
                    while (target.left!=null){
                        target=target.left;
                    }
                    return target;
                }else {
                    //则后继节点在不在一条右斜线向上数的第一个父节点
                    target  =t.parent;
                    Entry<K, V> sub  =t;
                    while (target!=null&& target.right==sub){
                        sub=target;
                        target=target.parent;
                    }
                    return target;
                }
            }
            t=target;
            

            
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
        Tree tree=new Tree();
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
