package model;

import java.util.Collection;
import java.util.List;

import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
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
			entdes = KIMAPI.entApi.getEntityDescription(uri);
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public KIMAttribute(URI uri, Collection<Literal> c){
		this.res = uri;
		try {
			entdes = KIMAPI.entApi.getEntityDescription(uri);
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values = (List<Literal>) c;
	}
	
	private void extract(){
			
	}
	
	public boolean isFunctional(){
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
		return res.toString();
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
