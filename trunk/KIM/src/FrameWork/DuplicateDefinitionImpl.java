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
import model.KIMRelation;


public class DuplicateDefinitionImpl implements DuplicateDefinition{

	@Override
	public List<Description> getElementDescription(KIMEntity e) {
		List<Description> list = new ArrayList<Description>();
		List<KIMAttribute> kimAttr =  e.attributes;
		for(KIMAttribute attr : kimAttr){
			if(!attr.getLabel().equals("comment") && !attr.isFunctional()){
				List<Literal> value = attr.values;
				for(Literal v : value){
					Description d = new Description(attr.getLabel().toString(),v.toString());
					list.add(d);
				}
				
			}
		}
		List<KIMRelation> kimRelation = e.relations;
		for(KIMRelation rela :kimRelation){
			if(rela.getLabel() == "hasAlias"){
				List<KIMEntity> listobj = rela.listobj;
				for(KIMEntity e1: listobj){
					Description d = new Description(rela.getLabel(),e1.getMainLabel().toString());
					list.add(d);
				}
			}
		}
		return list;
	}

	@Override
	public List<Description> getRelationDescription(KIMEntity e) {
		List<Description> list = new ArrayList<Description>();
		List<KIMRelation> kimRela = e.relations;
		for(KIMRelation rela: kimRela){
			if(!rela.getLabel().equals("hasAlias") && !rela.getLabel().equals("hasMainAlias") && !rela.getLabel().equals("type") &&  !rela.isFunctional()){
				List<KIMEntity> listobj = rela.listobj;
				for(KIMEntity k : listobj){
					Description d = new Description(rela.getLabel(),k.res.toString());
					list.add(d);
				}
			}
		}
		return list;
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
