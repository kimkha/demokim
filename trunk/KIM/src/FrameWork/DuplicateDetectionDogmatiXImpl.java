package FrameWork;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Description;
import model.KIMEntity;

import org.openrdf.model.URI;

import tool.Config;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;
import uk.ac.shef.wit.simmetrics.similaritymetrics.NeedlemanWunch;
import uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWatermanGotohWindowedAffine;

public class DuplicateDetectionDogmatiXImpl implements DuplicateDetection {

	private CandidateDefinition candef = null;
	private DuplicateDefinition dupdef = null;
	private double valueThreshold; // for string
	private double simThreshold; // for entity

	
	@Override
	public boolean isDuplicate(KIMEntity e1, KIMEntity e2) {
		double sim = getSimilarity(e1, e2);
		if (sim > getSimThreshold())
			return true;
		return false;
	}

	private boolean prune(KIMEntity e1, KIMEntity e2) {
		// TODO Auto-generated method stub
		// lay cac thuoc tinh / quan he don nhat
		// kiem tra xem co giong nhau hay khong
		
		return false;
	}

	@Override
	public double getSimilarity(KIMEntity e1, KIMEntity e2) {
		List<Description> eledes1 = getDupdef().getElementDescription(e1);
		List<Description> relades1 = getDupdef().getRelationDescription(e1);
		List<Description> eledes2 = getDupdef().getElementDescription(e2);
		List<Description> relades2 = getDupdef().getRelationDescription(e2);
		double simNe, difNe, simNr, difNr;
		simNe = difNe = simNr = difNr = 0;
		List<Description> set = new ArrayList<Description>();
		Description des1, des2;
		// find Ne
		for(int i=0; i < eledes1.size(); i++){
			des1 = eledes1.get(i);
			for(int j=0; j < eledes2.size(); j++){
				des2 = eledes2.get(j);
				double sim = getSim(des1,des2);
				if(sim >= getSimThreshold())
				{
					simNe+= getStrength(des1,des2);
					if(!set.contains(des1))
						set.add(des1);
					if(!set.contains(des2))
						set.add(des2);
					
				}
			}	
		}
		eledes1.removeAll(set);
		eledes2.removeAll(set);
		
		HashMap<String, Integer> he1 = new HashMap<String, Integer>();
		for (int i=0; i<eledes1.size(); i++) {
			String name = eledes1.get(i).getProperty();
			int c = 0;
			if (he1.containsKey(name)) {
				c = he1.get(name);
				he1.remove(name);
			}
			he1.put(name, (c+1));
		}
		HashMap<String, Integer> he2 = new HashMap<String, Integer>();
		for (int i=0; i<eledes2.size(); i++) {
			String name = eledes2.get(i).getProperty();
			int c = 0;
			if (he2.containsKey(name)) {
				c = he2.get(name);
				he2.remove(name);
			}
			he2.put(name, (c+1));
		}
		for (String s : he1.keySet()) {
			if (he2.containsKey(s)) {
				int v1 = he1.get(s);
				int v2 = he2.get(s);
				if (v1<v2) {
					difNe += v1;
				} else {
					difNe += v2;
				}
			}
		}
		set = new ArrayList<Description>();
		for(int i=0; i < relades1.size(); i++){
			des1 = relades1.get(i);
			for(int j=0; j < relades2.size(); j++){
				des2 = relades2.get(j);
				double sim = getSim(des1,des2);
				if(sim==1)
				{
					simNr+= getStrength(des1,des2);
					if(!set.contains(des1))
						set.add(des1);
					if(!set.contains(des2))
						set.add(des2);
				}
			}	
		}
		relades1.removeAll(set);
		relades2.removeAll(set);
		
		HashMap<String, Integer> h1 = new HashMap<String, Integer>();
		for (int i=0; i<relades1.size(); i++) {
			String name = relades1.get(i).getProperty();
			int c = 0;
			if (h1.containsKey(name)) {
				c = h1.get(name);
				h1.remove(name);
			}
			h1.put(name, (c+1));
		}
		HashMap<String, Integer> h2 = new HashMap<String, Integer>();
		for (int i=0; i<relades2.size(); i++) {
			String name = relades2.get(i).getProperty();
			int c = 0;
			if (h2.containsKey(name)) {
				c = h2.get(name);
				h2.remove(name);
			}
			h2.put(name, (c+1));
		}
		for (String s : h1.keySet()) {
			if (h2.containsKey(s)) {
				int v1 = h1.get(s);
				int v2 = h2.get(s);
				if (v1<v2) {
					difNr += v1;
				} else {
					difNr += v2;
				}
			}
		}
		return (simNe+simNr)/(simNe+simNr+difNe+difNr);
	}


	private double getStrength(Description des1, Description des2) {
		//return KIMAPI.getSemRepoApi().getStatementsCount(new URIImpl(WKBConstants.CLASS_LOCATION), new URIImpl(WKBConstants.PROPERTY_LONGITUDE), new LiteralImpl(""), true);
		double val = Config.getPriority("Country", des1.getProperty());
		return val;
	}

	private double getSim(Description des1, Description des2) {
		if(!isComparable(des1.getProperty(),des2.getProperty())){
			return 0;
		}else{
//			Levenshtein sim = new Levenshtein();
//			SmithWatermanGotohWindowedAffine sim = new SmithWatermanGotohWindowedAffine();
			NeedlemanWunch sim = new NeedlemanWunch();
			return sim.getSimilarity(des1.getValue(), des2.getValue());
		}
		
	}

	private boolean isComparable(String property, String property2) {
		// TODO Auto-generated method stub
		return (property.equals(property2));
	}

	@Override
	public KIMEntity getDuplicate(KIMEntity e) {
		// liet ke tat ca thuc the can so sanh -- candef.listCandidate(e)
		List<URI> candidatesList = getCandef().listCandidate(e);
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
	public List<Set<KIMEntity>> getDuplicateClus(KIMEntity entity) {
		List<URI> listCandidate = getCandef().listCandidate(entity);
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

	@Override
	public void setValueThreshold(double valueThreshold) {
		this.valueThreshold = valueThreshold;
	}

	@Override
	public double getValueThreshold() {
		return valueThreshold;
	}

	@Override
	public void setSimThreshold(double simThreshold) {
		this.simThreshold = simThreshold;
	}

	@Override
	public double getSimThreshold() {
		return simThreshold;
	}

	@Override
	public void setCandef(CandidateDefinition candef) {
		this.candef = candef;
	}

	@Override
	public CandidateDefinition getCandef() {
		return candef;
	}

	@Override
	public void setDupdef(DuplicateDefinition dupdef) {
		this.dupdef = dupdef;
	}

	@Override
	public DuplicateDefinition getDupdef() {
		return dupdef;
	}

}
