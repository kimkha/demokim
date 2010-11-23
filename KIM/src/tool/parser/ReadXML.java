package tool.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;

public class ReadXML {
	@SuppressWarnings("unchecked")
	public static List<EntityDescription> read() throws JDOMException, IOException {
		FileInputStream file = new FileInputStream("country.xml");
		SAXBuilder parser = new SAXBuilder();
		Document doc = parser.build(file);
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren();
		List<EntityDescription> entities = new ArrayList<EntityDescription>();
		for (int i=0; i<list.size(); i++) {
			EntityDescriptionImpl e = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#Country_C"+(i+1)));
			List<Element> attributes = list.get(i).getChildren();
			for (int j=0; j<attributes.size(); j++) {
				Element attr = attributes.get(j);
				String name = attr.getName().toLowerCase();
				if ("label".equals(name)) {
					e.addAttribute(
							new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), 
							new LiteralImpl(attr.getValue()));
				} else if ("hasalias".equals(name)) {
					e.addAttribute(
							new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), 
							new LiteralImpl(attr.getValue()));
				} else if ("type".equals(name)) {
					e.addAttribute(
							new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), 
							new LiteralImpl(attr.getValue()));
				} else if (!"hasmainalias".equals(name)) {
					if (isRelation(attr.getValue())) {
						e.addRelation(
								new URIImpl("http://proton.semanticweb.org/2006/05/protons#"+attr.getName()), 
								new URIImpl(attr.getValue()));
					} else {
						e.addAttribute(
								new URIImpl("http://proton.semanticweb.org/2006/05/protons#"+attr.getName()), 
								new LiteralImpl(attr.getValue()));
					}
				}
			}
			entities.add(e);
		}
		return entities;
	}

	private static boolean isRelation(String value) {
		if (value.toLowerCase().startsWith("http://")) {
			return true;
		}
		return false;
	}
}
