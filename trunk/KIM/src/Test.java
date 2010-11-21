import java.util.List;
import java.util.Set;

import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;

import model.KIMEntity;

import FrameWork.CandidateDefinitionImpl;
import FrameWork.DuplicateDefinitionImpl;
import FrameWork.DuplicateDetection;
import FrameWork.DuplicateDetectionDogmatiXImpl;

import com.ontotext.kim.client.CompareStyleConstants;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.SemanticQuery;

import test.TestData;
import tool.ConfigFile;
import tool.KIMAPI;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load default config...
		/*
		Set<String> keys = ConfigFile.getListClass();

		System.out.println(ConfigFile.getElementsByClass(keys.iterator().toString()));
		/**/
		
		KIMAPI.start();
		//TestData.importData();

		SemanticQuery seq1 = new SemanticQuery();

		try {
			seq1.addRequestedVar("PERS");
			seq1.setClass("PERS", WKBConstants.CLASS_MAN);
//			seq1.addNameRestriction("PERS",
//					CompareStyleConstants.COMPARE_STYLE_CONTAINS, "kha");
			List<KIMEntity> listEntities = KIMAPI.getEntities(seq1);

			KIMEntity entity = new KIMEntity(TestData.getTest10());
			
			DuplicateDetection dupl = new DuplicateDetectionDogmatiXImpl();
			dupl.setCandef(new CandidateDefinitionImpl());
			dupl.setDupdef(new DuplicateDefinitionImpl());
			dupl.setSimThreshold(0.99);
			dupl.setValueThreshold(1);
			
			
			for (int i=0; i<listEntities.size(); i++) {
				// TODO Do something
//				if (dupl.isDuplicate(entity, listEntities.get(i))) {
//					System.out.println(listEntities.get(i).getFullInfo());
//				}
				System.out.print(listEntities.get(i).getLabel()[0]+": ");
				System.out.println(dupl.getSimilarity(entity, listEntities.get(i)));
			}
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End");/**/
	}

}
