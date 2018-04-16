package com.qiju.game.car.ws.handler;

import com.qiju.game.car.core.bean.Player;
import com.qiju.game.car.util.Blowfish;
import com.qiju.game.car.ws.proto.MessageBody;
import com.qiju.game.car.ws.proto.MessageFactory;
import com.qiju.game.car.ws.proto.MessageSender;
import com.qiju.game.car.ws.session.IoSession;

/**
 * @author Qintingyin
 * 
 *         2018-4-2
 */
public class LoginHandler extends BaseClientRequestHandler {
	private static final String split_token = "\\|";
	private static final char split_username = '\002';
	private static Blowfish cipher = new Blowfish("");

	@Override
	public void handleClientRequest(IoSession session, MessageBody msg) {
		logger.info("handleClientRequest:" + msg.toString());
		String token = msg.getString("mcheck");
		String ud = msg.getString("uid");
		if (token == null || token.isEmpty()) {
			MessageSender.response(session, MessageFactory.getFailMsg(
					msg.getOP(), "mcheck can not be null"));
			return;
		}
		String userStr[] = ud.split("_");
		long uid = 0L;
		int site = -1;
		try{
			uid = Long.valueOf(userStr[1]);
		}catch (Exception e) {
			logger.error("用户登录失败", e);
		}
		String[] arr = token.split(split_token);
		String usernameString = cipher.decryptString(arr[0]);
		Player player = new Player(uid, site);
		player.setName(usernameString.substring(0,
				usernameString.indexOf(split_username)));
		String other = cipher.decryptString(arr[1]);
		String[] others = other.split(split_token);
		if(uid != Long.parseLong(others[0])){
			MessageSender.response(session, MessageFactory.getFailMsg(
					msg.getOP(), "mcheck is wrong"));
			return;
		}
		
		
		
		
	}

}
