package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Graph;
import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;

import tool.KIMAPI;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.semanticrepository.ClosableIterator;
import com.ontotext.kim.client.semanticrepository.SemanticRepositoryException;

public class KIMEntity extends KIMResource implements EntityDescription{

	private EntityDescription entdes = null;
	public boolean isExtracted = false;
	public List<KIMAttribute> attributes = null;
	public List<KIMRelation> relations = null;

	public KIMEntity(Resource res) {
		this.res = res;
		
	}

	public KIMEntity(EntityDescription ent) {
		this.entdes = ent;
		res = ent.getResource();
		extract();

	}
	
	public KIMEntity(File xmlfile){
		
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

	public Literal getMainLabel() {
		if(!isExtracted)
			extract();
		return entdes.getMainLabel();
	}

	public String[] getLabel() {
		String[] result;
		Collection<Literal> lit = entdes.getLabels();
		Iterator<Literal> it = lit.iterator();
		result = new String[lit.size()];
		int i = 0;
		while (it.hasNext()) {
			result[i] = it.next().toString();
			i++;
		}
		return result;
	}

	public KIMClass getKIMClass() {
		KIMClass kimClass = null;
		try {
			ClosableIterator<Resource> cl = KIMAPI.getSemRepoApi().getDirectClasses(res);
			Resource res = cl.next();
			kimClass = new KIMClass(res);
			
		} catch (SemanticRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kimClass;
	}

	public String getFullInfo() {
		if (isExtracted) {
			String str = "";
			str += getMainLabel() + "\n";
			for (int i = 0; i < attributes.size(); i++) {
				KIMAttribute attr = attributes.get(i);
				str += "( " + attr.getLabel();
				String[] listvalues = attr.getValues();
				for(int j=0; j< listvalues.length; j++){
					str += ", " + listvalues[j];
				}
				str += ")\n";
			}
			for (int i = 0; i < relations.size(); i++) {
				KIMRelation rela = relations.get(i);
				str += "( " + rela.getLabel();
				List<KIMEntity> listObject = rela.listobj;
				for(int j=0; j < listObject.size(); j++)
					str += ',' + listObject.get(j).res.toString();
				str += ")\n";
			}
			return str;
		} else
			return null;
	}

	public Resource getResource() {
		return this.res;
	}

	@Override
	public Collection<URI> getAttributeTypes() {
		// TODO Auto-generated method stub
		return entdes.getAttributeTypes();
	}

	@Override
	public Collection<Literal> getAttributes(URI arg0) {
		// TODO Auto-generated method stub
		return entdes.getAttributes(arg0);
	}

	@Override
	public Object getContext(URI arg0) {
		// TODO Auto-generated method stub
		return entdes.getContext(arg0);
	}

	@Override
	public Collection<URI> getContextTypes() {
		// TODO Auto-generated method stub
		return entdes.getContextTypes();
	}

	@Override
	public Collection<URI> getPrefetchedRelationTypes() {
		// TODO Auto-generated method stub
		return entdes.getPrefetchedRelationTypes();
	}

	@Override
	public Collection<EntityDescription> getPrefetchedRelations(URI arg0) {
		// TODO Auto-generated method stub
		return entdes.getPrefetchedRelations(arg0);
	}

	@Override
	public Collection<URI> getRelationTypes() {
		// TODO Auto-generated method stub
		return entdes.getRelationTypes();
	}

	@Override
	public Collection<Resource> getRelations(URI arg0) {
		// TODO Auto-generated method stub
		return entdes.getRelations(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return entdes.isEmpty();
	}

	@Override
	public Graph toRDF() {
		// TODO Auto-generated method stub
		return entdes.toRDF();
	}

	@Override
	public Collection<Literal> getLabels() {
		// TODO Auto-generated method stub
		return entdes.getLabels();
	}

	@Override
	public String stringValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
