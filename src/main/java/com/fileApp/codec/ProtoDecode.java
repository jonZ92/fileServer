package com.fileApp.codec;

import com.fileApp.pojo.FileBody;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


/**
 * @author jon 2021:09:27
 */


public class ProtoDecode extends MessageToMessageDecoder<ByteBuf> {
    private final Logger log = LogManager.getLogger(this.getClass());


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        byte[] file_byte = new byte[msg.writerIndex()];
        for (int i = 0; i < msg.writerIndex(); i++) {
            file_byte[i] = msg.readByte();
        }
        msg.resetReaderIndex();
        FileBody fileObject = FileBody.parseFrom(file_byte);
        out.add(fileObject);
    }
}
