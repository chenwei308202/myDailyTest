package com.cw.demo.netty.server;

import com.cw.demo.netty.server.channelhandler.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by chenwei01 on 2017/4/27.
 */
public class TimeServer {

    private  int port;

    public TimeServer(int port){
        this.port=port;
    }

    public void run() throws Exception{
        //因为使用NIO，指定NioEventLoopGroup来接受和处理新连接
        EventLoopGroup group = new NioEventLoopGroup();
        //创建bootstrap来启动服务器
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(group).
                //指定通道类型为NioServerSocketChannel
                        channel(NioServerSocketChannel.class).
                localAddress(port).
                //调用childHandler用来指定连接后调用的ChannelHandler
                        childHandler(new ChannelInitializer<Channel>() {
                    //这个方法传ChannelInitializer类型的参数，ChannelInitializer是个抽象类，所以需要实现initChannel方法，这个方法就是用来设置ChannelHandler
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new TimeServerHandler());
                    }
                });
        ChannelFuture future=boot.bind().sync();
        System.out.println( TimeServer.class.getName()+" started and listen on "+future.channel().localAddress());
    }

    public static void main(String[] args) {

        TimeServer timeServer=new TimeServer(8888);

        try {
            timeServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
