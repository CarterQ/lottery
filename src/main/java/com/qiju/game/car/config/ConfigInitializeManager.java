package com.qiju.game.car.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.qiju.game.car.config.bean.DataType;
import com.qiju.game.car.db.dao.ConfigDao;
import com.qiju.game.car.util.ClassUtil;

/**
 * 负责配置文件的初始化和检测更新
 * @author qintingyin
 *
 */
public class ConfigInitializeManager{
	protected static final Logger logger = Logger.getLogger(ConfigInitializeManager.class);
	private static ConfigInitializeManager instance = new ConfigInitializeManager();
	private Map<String, ConfigLoader> hotMap = new HashMap<String, ConfigLoader>();
	public static ConfigInitializeManager getInstance(){
		return instance;
	}
	private ConfigInitializeManager(){
		init();
	}
	private void init(){
		try {
			List<Class<?>> list = ClassUtil.getAllAssignedClass(ConfigLoader.class);
			for(Class<?> clazz:list){
				DataType type = clazz.getAnnotation(DataType.class);
				ConfigLoader loader = (ConfigLoader) clazz.newInstance();
				loader.load();
				if (type != null&&type.type().equals(DataType.Type.Hot)) {
					hotMap.put(clazz.getSimpleName(), loader);
				}
			}
		} catch (Exception e) {
			logger.error("error at init ConfigInitializeManager..", e);
		}
		//配置更新检测线程,定期读取数据库config表,根据结果判断需要更新的配置并更新
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000*60*5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ConfigDao dao = new ConfigDao();
					List<String> names = dao.queryAllChanges();
					if(names.size()>0){
						dao.resetChanges();
						for(String key:names){
							try{
								hotMap.get(key).load();
							}catch (Exception e) {
								logger.error("配置["+key+"]热更新出错...", e);
							}
						}
					}
				}
			}
		}, "configCheckThread").start();
	}
}