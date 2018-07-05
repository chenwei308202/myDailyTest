package com.cw.demo.algorithm;

/**
 * 单向链表反转
 *
 * 实现一个单链表的反转。 例如 10 9 8 7 6 5 4 3 2 1
 * 反转后  1 2 3 4 5 6 7 8 9 10
 *
 *
 * @author chenwei
 * @create 2018-07-05 10:11
 **/

public class ListReverseDemo {


    public static void main(String[] args) {
        Node firstNode=constructList();
        Node next = firstNode.next;
        Node reverse = reverse(firstNode, next);

        while (reverse != null) {
            System.out.println(reverse.value);
            reverse=reverse.next;
        }

    }

    /**
     * 反转链表并返回反转后的头结点
     * @param prve
     * @param next
     * @return
     */
    public static Node reverse(Node prve,Node next){
        Node last=null;
        if (next != null) {
            //如果不是最后一个节点，递归
            if (next.next != null) {
                last=reverse(next,next.next);
            }else {
                //是最后节点，返回作为头结点
                last=next;
            }
                next.next=prve;
                prve.next=null;
        }
        return  last;
    }

    static class Node{

        public Node next;

        private int value;

        public Node(int value){
            this.value=value;
        }

    }

    public static Node constructList(){
        //构造一个链表
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        Node node8=new Node(8);
        Node node9=new Node(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        return node1;
    }

}
