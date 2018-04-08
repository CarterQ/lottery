package com.qiju.game.car.config.loader;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.qiju.game.car.config.ConfigLoader;
import com.qiju.game.car.config.bean.ChooseType;
import com.qiju.game.car.config.bean.DataType;
import com.qiju.game.car.config.bean.DataType.Type;

/**
 * @author qintingyin
 * 2018年3月30日
 */
@DataType(type=Type.Hot)
public class ChooseTypeConfigLoader extends ConfigLoader {
	private String fileName = "chooseType.xml";
	@SuppressWarnings("unchecked")
	@Override
	public void load(){
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(getConfigInputStream(fileName));
			Element element = document.getRootElement();
			List<Element> list = element.elements();
			for(Element type:list){
				ChooseType chooseType = new ChooseType();
				chooseType.setId(Integer.parseInt(type.attribute("id").getValue()));
				chooseType.setName(type.attribute("name").getValue());
				chooseType.setMultiple(Integer.parseInt(type.attribute("multiply").getValue()));
				chooseType.setRatio(Integer.parseInt(type.attribute("ratio").getValue()));
				chooseType.setDesc(type.attribute("desc").getValue());
			}
		} catch (Exception e) {
			logger.error("error loading at "+fileName,e);
		}
	}
	public static void main(String[] args) {
		ChooseTypeConfigLoader loader = new ChooseTypeConfigLoader();
		loader.load();
	}
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
}
