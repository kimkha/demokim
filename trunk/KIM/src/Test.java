import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import model.KIMEntity;

import org.jdom.JDOMException;
import org.openrdf.model.URI;

import tool.KIMAPI;
import tool.parser.CountryXML;
import tool.parser.ReadXML;

import FrameWork.CandidateDefinitionImpl;
import FrameWork.DuplicateDefinition;
import FrameWork.DuplicateDefinitionImpl;
import FrameWork.DuplicateDetection;
import FrameWork.DuplicateDetectionDogmatiXImpl;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.SemanticQuery;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static void main(String[] args) throws IOException, JDOMException {
		// Load default config...
		/*
		Set<String> keys = ConfigFile.getListClass();

		System.out.println(ConfigFile.getElementsByClass(keys.iterator().toString()));
		/**/
		
		KIMAPI.start();
		//TestData.importData();
		//exportCountries();
		compareContries();
		System.out.println("End");/**/
		
	}
	
	public static void compareContries() throws JDOMException, IOException {
		List<EntityDescription> xmlEntities = ReadXML.read("countries_dirty.xml");
		
		DuplicateDetection dupl = new DuplicateDetectionDogmatiXImpl();
		dupl.setCandef(new CandidateDefinitionImpl());
		dupl.setDupdef(new DuplicateDefinitionImpl());
		dupl.setSimThreshold(0.5);
		dupl.setValueThreshold(0.7);
		
		FileWriter file = new FileWriter("result.csv");

		for (int i=0; i<xmlEntities.size(); i++) {
//		for (int i=0; i<10; i++) {
			KIMEntity e1 = new KIMEntity(xmlEntities.get(i));
			double max = -1;
			String nameMax = "";

			String firstLine = e1.getLabel()[0]+",";
			String secondLine = ",";
			
			Iterator<URI> kbEntities = KIMAPI.getAllEntityURIInClass(WKBConstants.CLASS_COUNTRY);
			while (kbEntities.hasNext()) {
				KIMEntity e2 = new KIMEntity(kbEntities.next());
				e2.extract();
				double sim = dupl.getSimilarity(e1, e2);
				if (sim>0.1) {
					firstLine += e2.getLabel()[0]+",";
					secondLine += sim+",";
				}
				if (sim>max) {
					max = sim;
					nameMax = e2.getLabel()[0];
				}
			}

			file.write(firstLine+"\n");
			file.write(secondLine+"\n\n");
			System.out.println(e1.getLabel()[0]+": "+nameMax+" ("+max+")");
		}
		file.close();
	}
	
	public static void exportCountries() throws IOException {
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
	}

}
