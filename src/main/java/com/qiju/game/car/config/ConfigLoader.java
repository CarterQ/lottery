package com.qiju.game.car.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.qiju.game.car.config.bean.DataType;


/**
 * 配置加载基类,所有配置相关的加载都需要继承该类,并放在com.qiju.game.car.config.loader包下<br>
 * PS:如果数据需要热更新,加上 {@linkplain DataType} 注释
 * @author qintingyin
 * 2018年3月30日
 */
public abstract class ConfigLoader {
	protected static final Logger logger = Logger.getLogger(ConfigLoader.class);
	protected String dir = "config/";
	
	/**
	 * 配置加载方法<br> 
	 * PS:该方法禁止抛出异常，需要对所有可能出现异常的代码进行try/catch
	 */
	public abstract void load();
	public abstract String getName();
	/**
	 * 获取config目录下的资源
	 * @param name
	 * @return
	 * @throws FileNotFoundException 
	 */
	public InputStream getConfigInputStream(String name) throws FileNotFoundException{
		return new FileInputStream(new File(ConfigInitializeManager.getBaseDir() +dir+name));
	}
	
}
