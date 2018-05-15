package com.cw.demo.netty.server.channelhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务端发送时间 示例
 * Created by chenwei01 on 2017/4/27.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter{


    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {

        final ByteBuf time=ctx.alloc().buffer(4);
       int serverTime= (int)((System.currentTimeMillis()/1000)+123456789);
        System.out.println(serverTime);
       time.writeInt(serverTime);
       // time.writeBytes("你好".getBytes("UTF-8"));
        ChannelFuture future =ctx.writeAndFlush(time);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
