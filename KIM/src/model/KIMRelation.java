package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;
public class KIMRelation extends KIMProperty{
	public List<KIMEntity> listobj;
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
		return false;
	}
	
	public boolean isInverseFunctional(){
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
		// TODO Auto-generated method stub
		
	}
}