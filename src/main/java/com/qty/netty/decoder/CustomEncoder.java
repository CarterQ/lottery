package com.qty.netty.decoder;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class CustomEncoder  extends MessageToMessageEncoder<ByteBuf>{

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		int length = msg.readableBytes();
		ByteBuf buf = Unpooled.buffer();
		buf.writeInt(length);
		buf.writeBytes(msg);
		out.add(buf);
	}

}
