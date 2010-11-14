import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;

import model.KIMEntity;

import com.ontotext.kim.client.CompareStyleConstants;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.SemanticQuery;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryException;

import tool.KIMAPI;


public class Test {
	public static void main(String args[]) {


		try {
			KIMAPI.start();
			System.out.println("QueryAPI obtained successful");
			SemanticQuery seq1 = new SemanticQuery();

		//	seq1.addRequestedVar("ORG"); // add variable ORG of class
			// Organization
			seq1.addRequestedVar("PERS"); // add variable PERS of class Person
		//	seq1.addRequestedVar("POS"); // add variable POS of class Position
		//	seq1.setClass("ORG", WKBConstants.CLASS_ORGANIZATION);
			seq1.setClass("PERS", WKBConstants.CLASS_MAN);
		//	seq1.setClass("POS", WKBConstants.CLASS_JOB_POSITION);
		//	seq1.addNameRestriction("POS",
		//			CompareStyleConstants.COMPARE_STYLE_CONTAINS, "manager"); // restrict
			
			seq1.addNameRestriction("PERS",
					CompareStyleConstants.COMPARE_STYLE_CONTAINS, "John"); // restrict
			// person
			// to
			// start
			// with
			// 'John'
		//	seq1.addPatternRestriction("PERS",
		//			WKBConstants.PROPERTY_HAS_POSITION, "POS"); // restrict
			// person to has
			// position in
			// "POS"
			// variable
		//	seq1.addPatternRestriction("POS",
		//			WKBConstants.PROPERTY_WITHIN_ORGANIZATION, "ORG"); // restrict
			// entities to be returned with labels
			// ----------------------------------------------------------------------------------
			List<KIMEntity> listEntities = KIMAPI.getEntities(seq1);
			
			FileWriter file = new FileWriter("entity.txt");
			System.out.println("[ Entity Result (begin) ]");
			file.write("[ Entity Result (begin) ]\n");
			System.out.println("Entity Result size : " + listEntities.size());
			file.write("Entity Result size : " + listEntities.size() + "\n");
			file.write("----------------------------\n");

			for (int i=0; i<listEntities.size(); i++) {
				// TODO Do something
				System.out.println(listEntities.get(i).getFullInfo());
				file.write(listEntities.get(i).getMainLabel()+"\n");
			}
			
			EntityDescriptionImpl e = new EntityDescriptionImpl(new URIImpl("http://www.ontotext.com/kim/2006/05/wkb#TL"));
			e.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("ThanhLuan"));
			e.addAttribute(new URIImpl("http://www.w3.org/2000/01/rdf-schema#comment"), new LiteralImpl("Luan trum"));
			e.addRelation(new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://proton.semanticweb.org/2006/05/protonu#Man"));
			try {
				KIMAPI.getEntApi().addEntityDescription(e);
			/*	KIMAPI.getSemRepoApi().startTransaction();
				KIMAPI.getSemRepoApi().addStatement(e.getResource(), new URIImpl("http://www.w3.org/2000/01/rdf-schema#label"), new LiteralImpl("KimTuyen"));
				KIMAPI.getSemRepoApi().addStatement(e.getResource(), new URIImpl("http://www.w3.org/2000/01/rdf-schema#comment"), new LiteralImpl("vo Viet Nghi"));
				KIMAPI.getSemRepoApi().addStatement(e.getResource(), new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), new URIImpl("http://proton.semanticweb.org/2006/05/protonu#Woman"));*/
			//	KIMAPI.getSemRepoApi().commitTransaction();
				
			} catch (SemanticRepositoryException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("---------------------------");
			System.out.println("[ Entity Result (end) ]");
			file.write("---------------------------\n");
			file.write("[ Entity Result (end) ]\n");
			file.close();
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		

	}
}
