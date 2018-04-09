package com.qiju.game.car.config.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 需要热更新的数据,设置type=Hot
 * @author Qintingyin
 *
 * 2018-4-9
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataType {
	Type type() default Type.Base;
	
	enum Type{
		Base,Hot
	}
}
