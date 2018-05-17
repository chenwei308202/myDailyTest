package com.cw.demo.algorithm;


/**
 * 检测链表是否有环
 *
 * @author chenwei
 * @create 2018-05-17 14:28
 **/

public class DetectListHasCircleDemo {

    /**
     * 链表 linkedList结构
     */
    static class NodeList{

        private Node first;

        private Node last;

        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Node getFirst() {
            return first;
        }

        public Node getLast(){
            return last;
        }

        public void put(Node node){
            if (size==0){
                first=last=node;
            }else {

                Node oldLastNode=last;
                this.last=node;
                oldLastNode.next=node;
            }
                size++;
        }



        static class Node{
            public Node next;

            public int value;

            public Node(int value){
                this.value=value;
            }

            @Override
            public String toString() {
                return "{ value="+value+"}";
            }
        }
    }

    public static boolean isLoop(NodeList nodeList){

        NodeList.Node first = nodeList.getFirst();

        NodeList.Node nodeSlow=first;
        NodeList.Node nodeFast=first.next;

        while (nodeSlow!=null && nodeFast!=null){
            nodeSlow=nodeSlow.next;

            if (nodeFast.next!=null){
                nodeFast=nodeFast.next.next;
            }else {
                //发现下一个node节点为null，说明不存在环
                return false;
            }

            if (nodeFast==nodeSlow){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        NodeList list=new NodeList();

        NodeList.Node nodeOne=new NodeList.Node(1);
        NodeList.Node nodeTwo=new NodeList.Node(2);
        NodeList.Node nodeThree=new NodeList.Node(3);
        NodeList.Node nodeFour=new NodeList.Node(4);
        NodeList.Node nodeFive=new NodeList.Node(5);
        NodeList.Node nodeFix=new NodeList.Node(6);
        NodeList.Node nodeSeven=new NodeList.Node(7);
        NodeList.Node nodeEight=new NodeList.Node(8);

        list.put(nodeOne);
        list.put(nodeTwo);
        list.put(nodeThree);
        list.put(nodeFour);
        list.put(nodeFive);
        list.put(nodeFix);
        list.put(nodeSeven);
        System.out.println(list);
        System.out.println("this list has a circle or not ?"+isLoop(list));
    }

}
