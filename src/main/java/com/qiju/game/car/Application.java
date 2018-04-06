package com.qiju.game.car;

import java.io.IOException;

import com.qiju.game.car.config.ConfigInitializeManager;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class Application {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		ConfigInitializeManager.getInstance();
        new WebsocketServer().startServer(8888);
	}

}
