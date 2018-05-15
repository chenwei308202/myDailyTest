package com.cw.demo.Algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 两个有序链表合并成一个有序的链表
 *
 * @author chenwei
 * @create 2018-05-15 16:48
 **/

public class TwoListInOne
{

    public static void main(String[] args) {
        List<Integer> list1=new ArrayList();
        List<Integer> list2=new ArrayList();

        for(int i=0;i<20;i++){
            list1.add(new Random().nextInt(100));
            list2.add(new Random().nextInt(100));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);

        System.out.println("------------------------合并-------------------------------");

        // 链表1 下标指针
        int index_1=0;
        // 链表2 下标指针
        int index_2=0;
        // 新链表下标指针
        int arrIndex=0;
        //合并后的新链表
        int [] newArr=new int[list1.size()+list2.size()];


        while (arrIndex<list1.size()+list2.size()){

                //若第一个链表 指针已经达到末尾
                if (index_1==list1.size()){
                    //则只将第二个链表的元素赋予新链表
                    newArr[arrIndex]=list2.get( index_2++);

                    //若第二个链表 指针已经达到末尾
                }else if  (index_2==list2.size()){
                    //则只将第一个链表的元素赋予新链表
                    newArr[arrIndex]=list1.get(index_1++);

                }else {
                    //若两链表下标指针都没有到达末尾，则 将小的元素赋予新链表并将指针加一
                    if (list1.get(index_1)<=list2.get(index_2)){
                        newArr[arrIndex]=list1.get(index_1++);
                    }else {
                        newArr[arrIndex]=list2.get( index_2++);
                    }
                }
                System.out.print(newArr[arrIndex] +",");
                //每循环一次，新链表下标加一
                arrIndex++;
            }


    }

}
