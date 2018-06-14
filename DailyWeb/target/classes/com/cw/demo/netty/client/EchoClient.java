package com.cw.demo.netty.client;

import com.cw.demo.netty.client.channelhandler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author  chenwei
 * Created by chenwei01 on 2017/4/25.
 */
public class EchoClient {

    private String host;

    private int port;

    public EchoClient(String host,int port){
        this.host=host;
        this.port=port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot=new Bootstrap();
        boot.group(group).
                channel(NioSocketChannel.class).
                remoteAddress(new InetSocketAddress(host, port)).
                handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EchoClientHandler());
                    }
                });
        ChannelFuture future=boot.connect().sync();
        future.channel().closeFuture().sync();

    }


    public static void main(String[] args) {
        try {
            new EchoClient("localhost",8888).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
