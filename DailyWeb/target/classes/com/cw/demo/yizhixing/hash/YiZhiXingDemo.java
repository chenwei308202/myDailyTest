package com.cw.demo.yizhixing.hash;

import java.util.*;

/**
 * 一致性hash算法demo
 * 分布式系统中常用的策略
 * Created by chenwei01 on 2018/4/18.
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

        Map mapTest=new HashMap();
        mapTest.put("aaa","aaa_value");
        mapTest.put("bbb","bbb_value");
        mapTest.put("ccc","ccc_value");
        mapTest.put("ddd","ddd_value");
        mapTest.put("eee","eee_value");
        mapTest.put("www","www_value");
        mapTest.put("qqq","qqq_value");
        mapTest.put("aaa","aaa_value");
        mapTest.put("hhh","hhh_value");
        mapTest.put("ttt","ttt_value");
        mapTest.put("jjj","jjj_value");
        mapTest.put("bbb","bbb_value");
        mapTest.put("ppp","ppp_value");
        mapTest.put("ooo","ooo_value");
        mapTest.put("uyu","uyu_value");
        mapTest.put("yu","yu_value");
        mapTest.put("aaa","aaa_value");
        mapTest.put("bds","bds_value");
        mapTest.put("drfreq","drfreq_value");
        mapTest.put("ertq","ertq_value");
        mapTest.put("erw","erw_value");
        mapTest.put("wre","wre_value");
        mapTest.put("er","er_value");

       for (Object obj:mapTest.keySet()){
           Integer index= HashUtil.hash((String) obj);
           SortedMap<Integer ,ServerNode> sortedMap = map.tailMap(index);
           Integer key=0;
           if (sortedMap==null||sortedMap.size()==0){
               key=map.firstKey();
           }else {
               key = sortedMap.firstKey();

           }
           ServerNode node =map.get(key);
           node.getData().put(index,mapTest.get(obj));
           System.out.println("key 为 " + obj + " index=" + index + " ，路由到了" + node.getServerAddr() + "索引为" + node.getIndex() + "的节点上，存储" + mapTest.get(obj));
       }
        System.out.println(map);

        //----------------------------------模拟 宕机的情况

        System.out.println("------------------------------------------------------------------------------------");

        map.remove(node3.getIndex());

        for (Object obj:mapTest.keySet()){
            Integer index= HashUtil.hash((String) obj);
            SortedMap<Integer ,ServerNode> sortedMap = map.tailMap(index);
            Integer key=0;
            if (sortedMap==null||sortedMap.size()==0){
                key=map.firstKey();
            }else {
                key = sortedMap.firstKey();

            }
            ServerNode node =map.get(key);
            System.out.println("key 为 "+obj+" index="+index+" ，从集群中取值"+ node.getServerAddr()+" 取得的结果为 "+node.getData().get(index));
        }


    }


}
