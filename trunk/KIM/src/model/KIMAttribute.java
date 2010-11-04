package model;

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

public class KIMAttribute extends KIMResource{
	public List<Literal> values;
	public EntityDescription entdes;
	
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
	
	private void extract(){
			
	}
	
	public boolean isFunctional(){
		Graph g = entdes.toRDF();
		Iterator<Statement> it = g.iterator();
		while(it.hasNext()){
			Statement sta = it.next();
			if(sta.getPredicate().toString() == "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"){
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
		return res.stringValue();
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
}	
