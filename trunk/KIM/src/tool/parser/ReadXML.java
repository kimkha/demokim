package tool.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.KIMEntity;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.openrdf.model.impl.URIImpl;

public class ReadXML {
	@SuppressWarnings("unchecked")
	public static List<KIMEntity> read() throws JDOMException, IOException {
		FileInputStream file = new FileInputStream("country.xml");
		SAXBuilder parser = new SAXBuilder();
		Document doc = parser.build(file);
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren();
		List<KIMEntity> entities = new ArrayList<KIMEntity>();
		for (int i=0; i<list.size(); i++) {
			KIMEntity e = new KIMEntity(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Country_C"+i));
			
			
			entities.add(e);
		}
		return entities;
	}
}
