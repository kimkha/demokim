import java.util.List;

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
import tool.KIMAPI;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KIMAPI.start();
		//TestData.importData();

		SemanticQuery seq1 = new SemanticQuery();

		try {
			seq1.addRequestedVar("PERS");
			seq1.setClass("PERS", WKBConstants.CLASS_PERSON);
//			seq1.addNameRestriction("PERS",
//					CompareStyleConstants.COMPARE_STYLE_CONTAINS, "kha");
			List<KIMEntity> listEntities = KIMAPI.getEntities(seq1);
			
			EntityDescriptionImpl e1 = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khadfsgsdfg"));
			e1.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("hsdkjhjsdh"));
			e1.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://proton.semanticweb.org/2006/05/protonu#Man"));
			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasAlias"), new LiteralImpl("Nguyen dfdfdfdgfKim Kha"));
			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasWife"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#suong"));
			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBoss"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nguyen"));
			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasBrother"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khanh"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasSister"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#khue"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#luan"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#trang"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#nghi"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tuyen"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#dieu"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tri"));
//			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#tai"));
			e1.addRelation(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasFriend"), new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#hoang"));
			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasNationlaty"), new LiteralImpl("china"));
			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#hasProvince"), new LiteralImpl("Pjkjkjkj"));
			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#birthday"), new LiteralImpl("8888u78787"));
//			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#height"), new LiteralImpl("177"));
//			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#weight"), new LiteralImpl("53"));
//			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#studentOf"), new LiteralImpl("Bach khoa"));
			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#department"), new LiteralImpl("May tinhhghghjghghh"));
			e1.addAttribute(new URIImpl("http://proton.semanticweb.org/2006/05/protons#company"), new LiteralImpl("Qdfdfdfhhhhjrfdehoach"));

			KIMEntity entity = new KIMEntity(e1);
			
			DuplicateDetection dupl = new DuplicateDetectionDogmatiXImpl();
			dupl.setCandef(new CandidateDefinitionImpl());
			dupl.setDupdef(new DuplicateDefinitionImpl());
			dupl.setSimThreshold(0.99);
			dupl.setValueThreshold(0.5);
			
			
			for (int i=0; i<listEntities.size(); i++) {
				// TODO Do something
//				if (dupl.isDuplicate(entity, listEntities.get(i))) {
//					System.out.println(listEntities.get(i).getFullInfo());
//				}
				System.out.println(dupl.getSimilarity(entity, listEntities.get(i)));
			}
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End");
	}

}
