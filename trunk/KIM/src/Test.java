import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import model.KIMEntity;

import org.openrdf.model.URI;

import tool.KIMAPI;
import tool.parser.CountryXML;

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
		/**/
		
		KIMAPI.start();
		//TestData.importData();
		CountryXML xml = new CountryXML();

		SemanticQuery seq1 = new SemanticQuery();
		FileWriter file = new FileWriter("country.txt");
		try {
			seq1.addRequestedVar("PERS");
			seq1.setClass("PERS", WKBConstants.CLASS_MAN);
//			seq1.addNameRestriction("PERS",
//					CompareStyleConstants.COMPARE_STYLE_CONTAINS, "kha");
			Iterator<URI> listEntities = KIMAPI.getAllEntityURIInClass(WKBConstants.CLASS_COUNTRY);
			int i=0;
			while(listEntities.hasNext()){
				i++;
				KIMEntity e = new KIMEntity(listEntities.next());
				e.extract();
				xml.addEntity(e);
				file.write(e.getFullInfo());
				file.write("\n----------------------\n");
			}
			System.out.println("No of Entities : " + i);
			file.write("No of Entities : " + i);
			file.close();
			xml.saveToXML("country.xml");
			
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End");/**/
	}

}
