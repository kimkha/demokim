package model;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;

import tool.KIMAPI;

public class KIMClass extends KIMResource{

	public KIMClass(Resource res){
		this.res =res;
	}
	public boolean isSuperClassOf(KIMClass kimClass){
		
		return false;
	}
	@Override
	public void extract() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String stringValue() {
		// TODO Auto-generated method stub
		return null;
	}

	
}