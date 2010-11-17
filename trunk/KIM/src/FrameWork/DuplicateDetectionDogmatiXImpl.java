package FrameWork;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;

import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.openrdf.model.URI;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.dom.*;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;

import model.Description;
import model.KIMEntity;

public class DuplicateDetectionDogmatiXImpl implements DuplicateDetection {

	private CandidateDefinition candef = null;
	private DuplicateDefinition dupdef = null;
	private double valueThreshold; // for string
	private double simThreshold; // for entity

	

	public boolean isDuplicate(KIMEntity e1, KIMEntity e2) {
		double sim = getSimilarity(e1, e2);
		if (sim > simThreshold)
			return true;
		return false;
	}

	private boolean prune(KIMEntity e1, KIMEntity e2) {
		// TODO Auto-generated method stub
		// lay cac thuoc tinh / quan he don nhat
		// kiem tra xem co giong nhau hay khong
		
		return false;
	}

	private double getSimilarity(KIMEntity e1, KIMEntity e2) {
		List<Description> eledes1 = dupdef.getElementDescription(e1);
		List<Description> relades1 = dupdef.getRelationDescription(e1);
		List<Description> eledes2 = dupdef.getElementDescription(e2);
		List<Description> relades2 = dupdef.getRelationDescription(e2);
		double simNe, difNe, simNr, difNr;
		simNe = difNe = simNr = difNr = 0;
		Set<Description> set = new TreeSet<Description>();
		Description des1, des2;
		// find Ne
		for(int i=0; i < eledes1.size(); i++){
			des1 = eledes1.get(i);
			for(int j=0; j < eledes2.size(); j++){
				des2 = eledes2.get(j);
				double sim = getSim(des1,des2);
				if( sim  < simThreshold)
				{
					simNe+= sim*getStrength(des1,des2);
					set.add(des1);
					set.add(des2);
				}
			}	
		}
		eledes1.removeAll(set);
		eledes2.removeAll(set);
		for(int i=0; i < eledes1.size(); i++){
			des1 = eledes1.get(i);
			for(int j=0; j < eledes2.size(); j++){
				des2 = eledes2.get(j);
				if(des1.getProperty() == des2.getProperty()){
					difNe += getStrength(des1,des2);
					eledes1.remove(i);
					eledes2.remove(j);
				}
			}
		}
		for(int i=0; i < relades1.size(); i++){
			des1 = relades1.get(i);
			for(int j=0; j < relades2.size(); j++){
				des2 = relades2.get(j);
				double sim = getSim(des1,des2);
				if( sim  == 1)
				{
					simNr+= sim*getStrength(des1,des2);
					set.add(des1);
					set.add(des2);
				}
			}	
		}
		relades1.removeAll(set);
		relades2.removeAll(set);
		for(int i=0; i < relades1.size(); i++){
			des1 = relades1.get(i);
			for(int j=0; j < relades2.size(); j++){
				des2 = relades2.get(j);
				if(des1.getProperty() == des2.getProperty()){
					difNr += getStrength(des1,des2);
					relades1.remove(i);
					relades2.remove(j);
				}
			}
		}
		return (simNe+simNr)/(simNe+simNr+difNe+difNr);
	}


	private double getStrength(Description des1, Description des2) {
		
		return 1;
	}

	private double getSim(Description des1, Description des2) {
		if(!isComparable(des1.getProperty(),des2.getProperty())){
			return 1;
		}else{
			Levenshtein sim = new Levenshtein();
			return sim.getSimilarity(des1.getValue(), des2.getValue());
		}
		
	}

	private boolean isComparable(String property, String property2) {
		// TODO Auto-generated method stub
		return (property == property2);
	}

	@Override
	public KIMEntity getDuplicate(KIMEntity e) {
		// liet ke tat ca thuc the can so sanh -- candef.listCandidate(e)
		List<URI> candidatesList = candef.listCandidate(e);
		// so sanh tung cap thuc the -- isDuplicate(KIMEntity e1, KIMEntity e2);
		for (URI uri : candidatesList) {
			KIMEntity e2 = new KIMEntity(uri);
			e2.extract();
			if (isDuplicate(e, e2)) {
				return e2;
			}
		}
		// tim ra thuc the trung lap voi thuc the da cho
		return null;
	}

	@Override
	public List<Set<KIMEntity>> getDuplicateClus() {
		List<URI> listCandidate = candef.listCandidate();
		List<Set<KIMEntity>> clus = new ArrayList<Set<KIMEntity>>();
		Iterator<URI> it1 = listCandidate.iterator();	
		Iterator<URI> it2 = listCandidate.iterator();
		while(it1.hasNext()){
			while(it2.hasNext()){
				KIMEntity e1 = new KIMEntity(it1.next());
				KIMEntity e2 = new KIMEntity(it2.next());
				e1.extract();
				e2.extract();
				if(isDuplicate(e1,e2)){
					 Set<KIMEntity> set = new HashSet<KIMEntity>();
					 set.add(e1);
					 set.add(e2);
					 clus.add(set);
				}
			}
		}
		return clus;
	}

	@Override
	public KIMEntity findDuplicate(KIMEntity e, Set<KIMEntity> setEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<KIMEntity> findDuplicates(KIMEntity e, Set<KIMEntity> setEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Set<KIMEntity>> getDuplicateClus(List<KIMEntity> liste1,
			List<KIMEntity> liste2) {
		// TODO Auto-generated method stub
		return null;
	}

}
