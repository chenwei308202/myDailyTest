package com.cw.demo.yizhixing.hash;

import java.util.HashMap;

/**
 * 服务器节点
 * Created by chenwei01 on 2017/1/18.
 */
public class ServerNode {

    private Integer index;

    private String serverAddr;

    private HashMap data=new HashMap();

    public ServerNode(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public ServerNode(int index, String serverAddr) {
        this.index = index;
        this.serverAddr = serverAddr;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public HashMap getData() {
        return data;
    }

    public void setData(HashMap data) {
        this.data = data;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    @Override
    public String toString() {
        return "ServerNode{" +
                "index=" + index +
                ", serverAddr='" + serverAddr + '\'' +
                ", data=" + data +
                '}';
    }
}
