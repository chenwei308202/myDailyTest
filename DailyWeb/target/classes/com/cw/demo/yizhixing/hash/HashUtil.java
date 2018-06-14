package com.cw.demo.yizhixing.hash;

/**
 * hash 工具类
 * Created by chenwei01 on 2017/1/17.
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
        hash= hash<0?Math.abs(hash):hash;
        //对2的32次方取余，实际上这里有些疑惑，为什么是这个数，是为了增大离散吗？
        return (int)(hash % Math.pow(2,32));
    }


}
