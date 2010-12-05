package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Graph;
import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.query.KIMQueryException;

import tool.KIMAPI;

public class KIMAttribute extends KIMProperty{
	private EntityDescription entdes;
	public List<Literal> values;
	public List<KIMAttribute> attributes = null;
	public List<KIMRelation> relations = null;
	public KIMAttribute(URI uri){
		this.res = uri;
		try {
			entdes = KIMAPI.getEntApi().getEntityDescription(uri);
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public KIMAttribute(URI uri, Collection<Literal> c){
		this.res = uri;
		try {
			entdes = KIMAPI.getEntApi().getEntityDescription(uri);
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values = (List<Literal>) c;
	}
	
	public void extract(){
		if (isExtracted == true)
			return;
		if (entdes == null) {
			try {
				entdes = KIMAPI.getEntApi().getEntityDescription(res);
			} catch (KIMQueryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		attributes = new ArrayList<KIMAttribute>();
		relations = new ArrayList<KIMRelation>();
		Collection<URI> atype = entdes.getAttributeTypes();
		Iterator<URI> it = atype.iterator();
		while (it.hasNext()) {
			URI attri = it.next();
			Collection<Literal> values = entdes.getAttributes(attri);
			KIMAttribute kimAttribute = new KIMAttribute(attri, values);
			attributes.add(kimAttribute);
		}

		Collection<URI> reltype = entdes.getRelationTypes();
		it = reltype.iterator();
		while (it.hasNext()) {
			URI rel = it.next();
			Collection<Resource> obj = entdes.getRelations(rel);
			KIMRelation kimRelation = new KIMRelation(rel, obj);
			relations.add(kimRelation);
		}
		isExtracted = true;
	}
	
	public boolean isFunctional(){
		Graph g = entdes.toRDF();
		Iterator<Statement> it = g.iterator();
		while(it.hasNext()){
			Statement sta = it.next();
			if(sta.getPredicate().toString().equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")){
				if(sta.getObject().toString().contains("FunctionalProperty")){
					return true;
				}
			}
		}
		return false;
	}
	
	public KIMClass getDomain(){
		return null;
	}
	
	public Resource getRange(){
		return null;
	}
	
	public KIMAttribute getSuperAttribute(){
		return null;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return ((URI)res).getLocalName();
	}
	
	public String getValueAt(int i){
		return values.get(i).toString();
	}
	public String[] getValues(){
		if(values.size() == 0)
			return null;
		String [] str = new String[values.size()];
		for(int i=0; i< values.size(); i++){
			str[i] = values.get(i).toString();
		}
		return str;
	}

	@Override
	public String stringValue() {
		// TODO Auto-generated method stub
		return null;
	}
}	
