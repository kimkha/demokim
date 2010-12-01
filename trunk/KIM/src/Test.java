import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import model.KIMEntity;

import org.jdom.JDOMException;
import org.openrdf.model.URI;

import tool.FMeasure;
import tool.KIMAPI;
import tool.parser.CountryXML;
import tool.parser.ReadXML;
import FrameWork.CandidateDefinitionImpl;
import FrameWork.DuplicateDefinitionImpl;
import FrameWork.DuplicateDetection;
import FrameWork.DuplicateDetectionDogmatiXImpl;

import com.ontotext.kim.client.model.WKBConstants;


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
		FMeasure fMeasure = ReadXML.readWithMeasure("countries_dirty.xml");
		
		DuplicateDetection dupl = new DuplicateDetectionDogmatiXImpl();
		dupl.setCandef(new CandidateDefinitionImpl(0));
		dupl.setDupdef(new DuplicateDefinitionImpl());
		dupl.setSimThreshold(0.5);
		dupl.setValueThreshold(0.7);
		
		for (int i=0; i<fMeasure.countEntities(); i++) {
//		for (int i=0; i<10; i++) {
			KIMEntity e1 = new KIMEntity(fMeasure.getEntity(i));
			double max = -1;
			String nameMax = "";
			fMeasure.setActive(i);

			Iterator<URI> kbEntities = KIMAPI.getAllEntityURIInClass(WKBConstants.CLASS_COUNTRY);
			while (kbEntities.hasNext()) {
				KIMEntity e2 = new KIMEntity(kbEntities.next());
				e2.extract();
				double sim = dupl.getSimilarity(e1, e2);
				fMeasure.addRelatedEntity(e2.getResource().stringValue(), sim);
				
				if (sim>max) {
					max = sim;
					nameMax = e2.getLabel()[0];
				}
			}

			System.out.println(e1.getLabel()[0]+": "+nameMax+" ("+max+")");
		}
		
		double step = 0.01;

		System.out.println("==== F-Measure ====");
		FileWriter file = new FileWriter("result.csv");
		file.write("a, f-measure\n");
		for (double i=0; i<=1; i+=step) {
			double f = fMeasure.getFMeasure(i);
			System.out.println("Threshold: "+i+", F-Measure: "+f);
			file.write(i+","+f+"\n");
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
