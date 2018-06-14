package com.cw.demo.vm;

/**
 * 虚拟机gc的演示
 *
 * @author chenwei
 * @create 2018-06-01 16:11
 **/

public class GcTest
{

    private static final  int _1MB=1024*1024;

    /**
     * VM参数： -verbose:gc     -Xms20M   堆最小20M
     *                          -Xmx20M   堆最大20M
     *                          -Xmn10M   新生代10M
     *                          -XX:SurvivorRatio=8   新生代与存活区比率 8:1
     *                          -XX:PrintGCDetails
     */
    public static void testAllocation(){

        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 =new byte[_1MB/4];
        allocation2 =new byte[4*_1MB];
        allocation3 =new byte[4*_1MB];
        //出现一次Minor GC
        allocation3=null;
        allocation4 =new byte[4*_1MB];




    }

    public static void main(String[] args) {
        testAllocation();
    }

}
