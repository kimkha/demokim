package tool;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.openrdf.model.impl.URIImpl;

import model.KIMEntity;

import com.ontotext.kim.client.GetService;
import com.ontotext.kim.client.KIMService;
import com.ontotext.kim.client.entity.EntityAPI;
import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.QueryAPI;
import com.ontotext.kim.client.query.SemanticQuery;
import com.ontotext.kim.client.query.SemanticQueryResult;
import com.ontotext.kim.client.query.SemanticQueryResultRow;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryAPI;
import com.ontotext.kim.ontology.Ontology;
import com.ontotext.kim.ontology.OntologyAPI;

public class KIMAPI {
	private static EntityAPI entApi = null;
	private static QueryAPI queryApi = null;
	private static SemanticRepositoryAPI semRepoApi = null;
	private static OntologyAPI ontoApi = null;
	private static Ontology onto = null;
	
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
}
