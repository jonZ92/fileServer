package com.fileApp.server.handler;


import com.fileApp.pojo.FileBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * @author jon 2021:09:11
 */


public class ServerFileHandler extends ChannelInboundHandlerAdapter {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        log.info("-.................... ");
//        String sendStr="hello world";
//        ctx.writeAndFlush(sendStr.getBytes());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FileBody fs=(FileBody)msg;
        log.info("---------: {}", fs.toString());
        FileBody.Builder filehand=FileBody.newBuilder();
        String code=randomCode();
        filehand.setVerCode(code);
        FileBody toBytes=filehand.build();
        ctx.writeAndFlush(toBytes.toByteArray());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("错误============>:{}", cause.getMessage());
        ctx.close();
    }

    private static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
