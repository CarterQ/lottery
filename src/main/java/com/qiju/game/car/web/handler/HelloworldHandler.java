/**
 * 
 */
package com.qiju.game.car.web.handler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
@RestController
public class HelloworldHandler {
	@GetMapping("/")
	public String hello(){
		return "hello";
	}
}
