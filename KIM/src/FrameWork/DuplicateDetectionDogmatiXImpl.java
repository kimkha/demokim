package FrameWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.openrdf.model.URI;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.dom.*;
import com.ontotext.kim.client.entity.EntityDescriptionImpl;

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

	private boolean prun(KIMEntity e1, KIMEntity e2) {
		// TODO Auto-generated method stub
		return false;
	}

	private double getSimilarity(KIMEntity e1, KIMEntity e2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double getSimilarity(Map m1, Map m2) {
		return 0;
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
		List clus = new ArrayList();
		Iterator<URI> it1 = listCandidate.iterator();	
		Iterator<URI> it2 = listCandidate.iterator();
		while(it1.hasNext()){
			while(it2.hasNext()){
				KIMEntity e1 = new KIMEntity(it1.next());
				KIMEntity e2 = new KIMEntity(it2.next());
				e1.extract();
				e2.extract();
				if(isDuplicate(e1,e2)){
					 Set set = new HashSet();
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
