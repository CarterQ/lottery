package com.qiju.game.car.config.loader;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.qiju.game.car.config.ConfigLoader;
import com.qiju.game.car.config.DataType;
import com.qiju.game.car.config.DataType.Type;

/**
 * @author qintingyin
 * 2018年3月30日
 */
@DataType(type=Type.Hot)
public class ChooseTypeConfigLoader extends ConfigLoader {
	private String fileName = "chooseType.xml";
	/* (non-Javadoc)
	 * @see com.qiju.game.car.config.ConfigLoader#load()
	 */
	@Override
	public void load(){
		System.out.println(dir+fileName+"--");
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(dir+fileName));
			Element element = document.getRootElement();
			logger.info(element.getName());
		} catch (DocumentException e) {
			logger.error("error loading at "+fileName,e);
		}
	}
	public static void main(String[] args) {
		ChooseTypeConfigLoader loader = new ChooseTypeConfigLoader();
		loader.load();
	}
	@Override
	public String getName() {
		return "ChooseTypeConfigLoader";
	}
	
}
