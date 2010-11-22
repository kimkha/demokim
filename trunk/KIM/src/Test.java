import hcmut.kim.FrameWork.CandidateDefinitionImpl;
import hcmut.kim.FrameWork.DuplicateDefinitionImpl;
import hcmut.kim.FrameWork.DuplicateDetection;
import hcmut.kim.FrameWork.DuplicateDetectionDogmatiXImpl;
import hcmut.kim.model.KIMEntity;
import hcmut.kim.test.TestData;
import hcmut.kim.tool.ConfigFile;
import hcmut.kim.tool.KIMAPI;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openrdf.model.URI;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;



import com.ontotext.kim.client.CompareStyleConstants;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;
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
				file.write(e.getFullInfo());
				file.write("\n----------------------\n");
			}
			file.write("No of Entities : " + i);
			file.write("END");
			file.close();
			
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End");/**/
	}

}
