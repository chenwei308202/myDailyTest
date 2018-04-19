package com.cw.demo.yizhixing.hash;

/**
 * hash 工具类
 * Created by chenwei01 on 2018/4/18.
 */
public class HashUtil {

    /**
     * 通过key计算下标
     * 采用FNV算法
     * @param key 节点值
     * @return
     */
    public  static  int hash(String key){
        final int p = 16777619;
        int hash = (int)2166136261L;
        for(int i=0;i<key.length();i++){
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return hash<0?Math.abs(hash):hash;
    }


}
