package FrameWork;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openrdf.model.Graph;
import org.openrdf.model.Literal;
import org.openrdf.model.Statement;

import model.Description;
import model.DupDefPolicy;
import model.KIMAttribute;
import model.KIMEntity;


public class DuplicateDefinitionImpl implements DuplicateDefinition{

	@Override
	public List<Description> getElementDescription(KIMEntity e) {
		List<Description> list = new ArrayList();
		List<KIMAttribute> kimAttr =  e.attributes;
		for(KIMAttribute attr : kimAttr){
			if(attr.getLabel() != "label" && attr.getLabel() != "comment"){
				List<Literal> value = attr.values;
				for(Literal v : value){
					Description 
				}
				
			}
		}
		return null;
	}

	@Override
	public List<Description> getRelationDescription(KIMEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDupDefFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDupDefPolicy(DupDefPolicy d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Description> getMapEleDescription(KIMEntity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Description> getMapRelaDescription(KIMEntity e) {
		// TODO Auto-generated method stub
		return null;
	}


}
