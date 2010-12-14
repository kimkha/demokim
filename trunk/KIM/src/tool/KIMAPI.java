package tool;

import gate.creole.ontology.OConstants.OWL;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;

import model.KIMEntity;

import com.ontotext.kim.client.GetService;
import com.ontotext.kim.client.KIMService;
import com.ontotext.kim.client.entity.EntityAPI;
import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.QueryAPI;
import com.ontotext.kim.client.query.SemanticQuery;
import com.ontotext.kim.client.query.SemanticQueryResult;
import com.ontotext.kim.client.query.SemanticQueryResultRow;
import com.ontotext.kim.client.semanticrepository.ClosableIterator;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryAPI;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryException;
import com.ontotext.kim.ontology.Ontology;
import com.ontotext.kim.ontology.OntologyAPI;

public class KIMAPI {
	private static EntityAPI entApi = null;
	private static QueryAPI queryApi = null;
	private static SemanticRepositoryAPI semRepoApi = null;
	private static OntologyAPI ontoApi = null;
	private static Ontology onto = null;
	private static Iterator<URI> functionalProperties = null;
	private static Iterator<URI> inverseFunctionalProperties = null;
	public static void start(){
		KIMService service;
		try {
			service = GetService.from();
			setQueryApi(service.getQueryAPI());
			setEntApi(service.getEntityAPI());
			setOntoApi(service.getOntologyAPI());
			setSemRepoApi(service
					.getSemanticRepositoryAPI());
			setOnto(ontoApi.getOntology());
			functionalProperties = KIMAPI.getAllEntityURIInClass(new URIImpl(OWL.FUNCTIONALPROPERTY));
			inverseFunctionalProperties = KIMAPI.getAllEntityURIInClass(new URIImpl(OWL.INVERSEFUNCTIONALPROPERTY));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static List<KIMEntity> getEntities(SemanticQuery seq) {
		if (getQueryApi() == null) {
			System.out.println("You must call KIMAPI.start() first");
			return null;
		}
		try {
			List<KIMEntity> list = new ArrayList<KIMEntity>();
			SemanticQueryResult resEntities = getQueryApi().getEntities(seq);
			for (SemanticQueryResultRow row : resEntities) {
				EntityDescription e = getEntApi().getEntityDescription(new URIImpl(
						row.get(0).toString()));
				list.add(new KIMEntity(e));
			}
			return list;
		} catch (KIMQueryException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static KIMEntity getEntity(URI uri) {
		if (getQueryApi() == null) {
			System.out.println("You must call KIMAPI.start() first");
			return null;
		}
		try {
			EntityDescription e = getEntApi().getEntityDescription(uri);
			return new KIMEntity(e);
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void setEntApi(EntityAPI entApi) {
		KIMAPI.entApi = entApi;
	}

	public static EntityAPI getEntApi() {
		return entApi;
	}

	public static void setQueryApi(QueryAPI queryApi) {
		KIMAPI.queryApi = queryApi;
	}

	public static QueryAPI getQueryApi() {
		return queryApi;
	}

	public static void setSemRepoApi(SemanticRepositoryAPI semRepoApi) {
		KIMAPI.semRepoApi = semRepoApi;
	}

	public static SemanticRepositoryAPI getSemRepoApi() {
		return semRepoApi;
	}

	public static void setOntoApi(OntologyAPI ontoApi) {
		KIMAPI.ontoApi = ontoApi;
	}

	public static OntologyAPI getOntoApi() {
		return ontoApi;
	}

	public static void setOnto(Ontology onto) {
		KIMAPI.onto = onto;
	}

	public static Ontology getOnto() {
		return onto;
	}

	public static Iterator<URI> getAllEntityURIInClass(Resource kimClass) {
		try {
			return semRepoApi.getInstances(kimClass);
		} catch (SemanticRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*SemanticQuery seq = new SemanticQuery();
		List<URI> list = new ArrayList<URI>();
		try {
			seq.addRequestedVar("KIMCLASSS");
			seq.setClass("KIMCLASS", kimClass.toString());
			SemanticQueryResult resEntities = getQueryApi().getEntities(seq);
			for (SemanticQueryResultRow row : resEntities) {
				list.add(new URIImpl(row.get(0).toString()));
			}
			return list;
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}
	
	public static Iterator<URI> getAllEntityURIInClass(String kimClass) {
		try {
			ClosableIterator<URI> ci = semRepoApi.getInstances(new URIImpl(kimClass));
		
			return ci;
		} catch (SemanticRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*SemanticQuery seq = new SemanticQuery();
		List<URI> list = new ArrayList<URI>();
		try {
			seq.addRequestedVar("KIMCLASSS");
			seq.setClass("KIMCLASS", kimClass.toString());
			SemanticQueryResult resEntities = getQueryApi().getEntities(seq);
			for (SemanticQueryResultRow row : resEntities) {
				list.add(new URIImpl(row.get(0).toString()));
			}
			return list;
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}
	
	public static boolean isFunctionalProperty(URI uri){
		while(functionalProperties.hasNext()){
			if(functionalProperties.next().toString().equals(uri.toString())){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isInverseFunctionalProperty(URI uri){
		while(inverseFunctionalProperties.hasNext()){
			if(inverseFunctionalProperties.next().toString().equals(uri.toString())){
				return true;
			}
		}
		return false;
	}
}
