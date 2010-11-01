import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.KIMEntity;

import org.openrdf.model.Graph;
import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.Value;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;

import tool.Description;
import tool.KIMAPI;

import com.ontotext.kim.client.*;

import com.ontotext.kim.client.coredb.CoreDbAPI;
import com.ontotext.kim.client.coredb.query.CoreDbEntity;
import com.ontotext.kim.client.corpora.CorporaAPI;
import com.ontotext.kim.client.entity.EntityAPI;
import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.QueryAPI;
import com.ontotext.kim.client.query.SemanticQuery;
import com.ontotext.kim.client.query.SemanticQueryResult;
import com.ontotext.kim.client.query.SemanticQueryResultRow;
import com.ontotext.kim.client.query.SemanticQuery.ReturnLabels;
import com.ontotext.kim.client.semanticannotation.SemanticAnnotationAPI;
import com.ontotext.kim.client.semanticrepository.ClosableIterator;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryAPI;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryException;
import com.ontotext.kim.ontology.Ontology;
import com.ontotext.kim.ontology.OntologyAPI;

public class Test {
	public static void main(String args[]) {

		try {
			KIMService serviceKim = GetService.from();
			System.out.println("KIM Server connected.");
			QueryAPI queryApi = serviceKim.getQueryAPI();
			EntityAPI entApi = serviceKim.getEntityAPI();
			OntologyAPI ontoApi = serviceKim.getOntologyAPI();
		    SemanticRepositoryAPI semRepoApi = serviceKim.getSemanticRepositoryAPI();
		    
		    KIMAPI.entApi = entApi;
		    KIMAPI.queryApi = queryApi;
		    KIMAPI.semApi = semRepoApi;
			System.out.println("QueryAPI obtained successful");
			SemanticQuery seq1 = new SemanticQuery();
			Ontology onto = ontoApi.getOntology();
			
			FileWriter file = new FileWriter("entity.txt");
			seq1.addRequestedVar("ORG"); // add variable ORG of class
			// Organization
			seq1.addRequestedVar("PERS"); // add variable PERS of class Person
			seq1.addRequestedVar("POS"); // add variable POS of class Position
			seq1.setClass("ORG", WKBConstants.CLASS_ORGANIZATION);
			seq1.setClass("PERS", WKBConstants.CLASS_PERSON);
			seq1.setClass("POS", WKBConstants.CLASS_JOB_POSITION);
			seq1.addNameRestriction("POS",
					CompareStyleConstants.COMPARE_STYLE_CONTAINS, "manager"); // restrict
			// position
			// to
			// contain
			// 'manager'
			seq1.addNameRestriction("PERS",
					CompareStyleConstants.COMPARE_STYLE_STARTS_WITH, "John"); // restrict
			// person
			// to
			// start
			// with
			// 'John'
			seq1.addPatternRestriction("PERS",
					WKBConstants.PROPERTY_HAS_POSITION, "POS"); // restrict
			// person to has
			// position in
			// "POS"
			// variable
			seq1.addPatternRestriction("POS",
					WKBConstants.PROPERTY_WITHIN_ORGANIZATION, "ORG"); // restrict
			// entities to be returned with labels
			// ----------------------------------------------------------------------------------
			SemanticQueryResult resEntities = queryApi.getEntities(seq1);
			
			System.out.println("[ Entity Result (begin) ]");
			file.write("[ Entity Result (begin) ]\n");
			System.out.println("Entity Result size : " + resEntities.size());
			file.write("Entity Result size : " + resEntities.size()+ "\n");
			for (SemanticQueryResultRow row : resEntities) {
				System.out.println(" - ---------------------------");
				file.write("----------------\n");
				EntityDescription e = entApi.getEntityDescription(new URIImpl(
						row.get(0).toString()));
				
				KIMEntity en = new KIMEntity(e);
				KIMEntity et = en.relations.get(0).listobj.get(0);
				et.extract();
				
				System.out.println(en.getMainLabel());
				System.out.println(en.isExtracted);
				System.out.println(en.getFullInfo());
				System.out.println(et.getMainLabel());
			}
	
			file.close();
			System.out.println("---------------------------");
			System.out.println("[ Entity Result (end) ]");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Remote");
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Notbound");
			e.printStackTrace();
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
