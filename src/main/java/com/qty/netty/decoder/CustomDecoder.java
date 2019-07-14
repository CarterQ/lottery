package com.qty.netty.decoder;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class CustomDecoder  extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		msg.markReaderIndex();
		int count = msg.readInt();
		if(msg.readableBytes()>=count){
			ByteBuf length1 = msg.readRetainedSlice(count);
			out.add(length1);
		}else{
			msg.resetReaderIndex();
		}
	}

}
