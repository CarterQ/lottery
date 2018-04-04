/**
 * 
 */
package com.qiju.game.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
@SpringBootApplication
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		new WebsocketServer().startServer(8888);
	}

}
