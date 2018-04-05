package com.qiju.game.car.config;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataType {
	Type type() default Type.Base;
	
	enum Type{
		Hot,Base
	}
}
