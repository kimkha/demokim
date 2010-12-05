package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;

import tool.KIMAPI;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
@SuppressWarnings("serial")
public class KIMRelation extends KIMProperty{
	private EntityDescription entdes;
	public List<KIMEntity> listobj;
	public List<KIMAttribute> attributes = null;
	public List<KIMRelation> relations = null;
	public Collection<Resource> type = null;
	public KIMRelation(URI uri){
		this.res = uri;
		listobj = new ArrayList<KIMEntity>();
		
	}
	
	public KIMRelation(URI uri, Collection<Resource> obj){
		this.res = uri;
		listobj = new ArrayList<KIMEntity>();
		Iterator<Resource> it = obj.iterator();
		while(it.hasNext()){
			Resource resource = it.next();
			KIMEntity entity = new KIMEntity(resource);
			listobj.add(entity);
		}
	}
	
	public boolean isFunctional(){
		Iterator<Resource> it = type.iterator();
		while(it.hasNext()){
			if(it.next().stringValue().equals("FunctionalProperty")){
				return true;
			}
		}
		return false;
	}
	
	public boolean isInverseFunctional(){
		Iterator<Resource> it = type.iterator();
		while(it.hasNext()){
			if(it.next().stringValue().equals("InverseFunctionalProperty")){
				return true;
			}
		}
		return false;
	}
	
	public boolean isTransitive(){
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

	@Override
	public void extract() {
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
		
		 Collection<Resource> type = entdes.getRelations(new URIImpl(WKBConstants.RDF_NS+"type"));
		 isExtracted = true;
		
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return ((URI)res).getLocalName();
	}

	@Override
	public String stringValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
