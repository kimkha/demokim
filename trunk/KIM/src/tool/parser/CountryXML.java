package tool.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.KIMEntity;

public class CountryXML {
	private List<KIMEntity> list = new ArrayList<KIMEntity>();
	public void saveToXML(String filename) throws IOException {
		FileWriter file = new FileWriter(filename);
		file.write("<?xml version=\"1.0\"?>\n<Countries>\n");
		
		for (int i=0; i<list.size(); i++) {
			file.write(list.get(i).getXML("\t", "Country"));
		}
		
		file.write("</Countries>\n");
		file.close();
	}
	
	public void addEntity(KIMEntity entity) {
		if (entity!=null) {
			if (!entity.isExtracted) {
				entity.extract();
			}
			list.add(entity);
		}
	}
}
