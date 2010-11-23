import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import model.KIMEntity;

import org.jdom.JDOMException;
import org.openrdf.model.URI;

import tool.KIMAPI;
import tool.parser.CountryXML;
import tool.parser.ReadXML;

import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.SemanticQuery;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Load default config...
		/*
		Set<String> keys = ConfigFile.getListClass();

		System.out.println(ConfigFile.getElementsByClass(keys.iterator().toString()));
		/**
		
		KIMAPI.start();
		//TestData.importData();
		CountryXML xml = new CountryXML();

		Iterator<URI> listEntities = KIMAPI.getAllEntityURIInClass(WKBConstants.CLASS_COUNTRY);
		int i=0;
		while(listEntities.hasNext()){
			i++;
			KIMEntity e = new KIMEntity(listEntities.next());
			e.extract();
			xml.addEntity(e);
		}
		System.out.println("No of Entities : " + i);
		xml.saveToXML("country.xml");
		
		System.out.println("End");/**/
		
		try {
			ReadXML.read();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
