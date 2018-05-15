package com.cw.demo.netty.client.channelhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by chenwei01 on 2017/4/27.
 */
public class TimeClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf o) throws Exception {
        System.out.println("Client received: " + o.readInt());
    }
}
