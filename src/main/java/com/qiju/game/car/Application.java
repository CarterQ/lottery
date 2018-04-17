package com.qiju.game.car;

import com.qiju.game.car.config.ConfigInitializeManager;
import com.qiju.game.car.core.state.StateFactory;
import com.qiju.game.car.ws.WebsocketServer;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class Application {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(Application.class.getResource("log4j.xml").getPath());
		ConfigInitializeManager.getInstance();
//		StateFactory.startGame();
//        new WebsocketServer().startServer(8888);
	}

}
