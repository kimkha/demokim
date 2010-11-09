package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;

import tool.KIMAPI;

import com.ontotext.kim.client.entity.EntityDescription;
import com.ontotext.kim.client.query.KIMQueryException;

public class KIMEntity extends KIMResource {

	public EntityDescription entdes = null;
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

	public String getMainLabel() {
		return entdes.getMainLabel().toString();
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
		return null;
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
			return str;
		} else
			return null;
	}

	public String getResource() {
		return this.res.toString();
	}

}
