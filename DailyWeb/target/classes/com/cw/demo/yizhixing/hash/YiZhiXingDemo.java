package com.cw.demo.yizhixing.hash;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 一致性hash算法demo
 * 分布式系统中常用的策略
 * Created by chenwei01 on 2017/1/18.
 */
public class YiZhiXingDemo {

    public static void main(String[] args) {


        //将各个节点的hash计算后放入 集合中排序
        ServerNode node1=new ServerNode("192.168.21.58");
        ServerNode node2=new ServerNode("192.168.1.9");
        ServerNode node3=new ServerNode("192.168.82.220");
        ServerNode node4=new ServerNode("192.168.72.125");
        ServerNode node5=new ServerNode("192.168.12.112");
        ServerNode node6=new ServerNode("192.168.3.48");

        node1.setIndex(HashUtil.hash(node1.getServerAddr()));
        node2.setIndex(HashUtil.hash(node2.getServerAddr()));
        node3.setIndex(HashUtil.hash(node3.getServerAddr()));
        node4.setIndex(HashUtil.hash(node4.getServerAddr()));
        node5.setIndex(HashUtil.hash(node5.getServerAddr()));
        node6.setIndex(HashUtil.hash(node6.getServerAddr()));

        TreeMap<Integer,ServerNode> map=new TreeMap<Integer,ServerNode>();
        map.put(node1.getIndex(), node1);
        map.put(node2.getIndex(), node2);
        map.put(node3.getIndex(), node3);
        map.put(node4.getIndex(), node4);
        map.put(node5.getIndex(), node5);
        map.put(node6.getIndex(), node6);

        Integer Serverkey=0;
        String keyStr="";
       for (int i=97;i<123;i++){
           keyStr= String.valueOf ((char)i);
           Integer index= HashUtil.hash(keyStr);
           // 获取 大于key的hash值的第一台服务器 ，若取不到，则取 第一台服务器
           SortedMap<Integer ,ServerNode> sortedMap = map.tailMap(index);
           if (sortedMap==null||sortedMap.size()==0){
               Serverkey=map.firstKey();
           }else {
               Serverkey = sortedMap.firstKey();
           }
           ServerNode node =map.get(Serverkey);

           node.getData().put(keyStr, StringUtils.upperCase(keyStr));
           System.out.println("key 为 " + keyStr + " ，路由到下标为" +Serverkey+ "索引为" + node.getIndex() + "的节点上存储");
       }
        System.out.println(map);

        //----------------------------------模拟 宕机的情况
        map.remove(node1.getIndex());
        System.out.println(map.size());
        for (int i=97;i<123;i++){
            keyStr= String.valueOf ((char)i);
            Integer index= HashUtil.hash(keyStr);
            // 获取 大于key的hash值的第一台服务器 ，若取不到，则取 第一台服务器 --start
            SortedMap<Integer ,ServerNode> sortedMap = map.tailMap(index);
            if (sortedMap==null||sortedMap.size()==0){
                Serverkey=map.firstKey();
            }else {
                Serverkey = sortedMap.firstKey();
            }
            ServerNode node =map.get(Serverkey);
            System.out.println("key 为 "+keyStr+" 索引到下标为 "+Serverkey+"的server， 取得的结果为 "+node.getData().get(keyStr));
        }
    }
}
