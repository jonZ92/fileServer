package com.fileApp.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author jon 2021:09:27
 */


public final class ProtoEncode extends MessageToByteEncoder {


    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        byte [] bytes= (byte[]) msg;
        out.writeBytes(bytes);
    }
}
