package FrameWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openrdf.model.URI;

import tool.DuplicateAPI;
import tool.KIMAPI;

import model.KIMEntity;

public class DuplicateDetectionImpl implements DuplicateDetection{
	
	private CandidateDefinition candef  = null;
	private DuplicateDefinition dupdef  = null;
	private double valueThreshold; // for string
	private double simThreshold; // for entity
	
	private double getSimilarityAttribute(Map m1, Map m2){
		return 0;
	}
	
	private double getContractoryAttribute(Map m1, Map m2){
		return 0;
	}
	
	
	private DuplicateResult isDuplicate(KIMEntity e1, KIMEntity e2){
		DuplicateResult dupl = new DuplicateResult();
		dupl.similary = DuplicateAPI.Similarity(e1, e2);
		dupl.isDuplicate = (dupl.similary >= simThreshold);
		return dupl;
	}
	
	
	@Override
	public KIMEntity getDuplicate(KIMEntity e) {
		// liet ke tat ca thuc the can so sanh -- candef.listCandidate(e)
		candef = new CandidateDefinitionImpl();
		List<URI> list = candef.listCandidate(e);
		List<KIMEntity> candidates = new ArrayList<KIMEntity>();
		List<DuplicateResult> duplicate = new ArrayList<DuplicateResult>();
		
		for (int i=0; i<list.size(); i++) {
			KIMEntity entity = KIMAPI.getEntity(list.get(i));
			// so sanh tung cap thuc the -- isDuplicate(KIMEntity e1, KIMEntity e2);
			DuplicateResult dupl = this.isDuplicate(e, entity);
			if (dupl.isDuplicate) {
				candidates.add(entity);
				duplicate.add(dupl);
			}
		}
		
		// tim ra thuc the trung lap voi thuc the da cho
		double max = 0;
		KIMEntity dupl = null;
		if (candidates!=null && duplicate != null && candidates.size() == duplicate.size()) {
			for (int i=0; i<candidates.size(); i++) {
				double sim = duplicate.get(i).similary;
				if (sim>max) {
					max = sim;
					dupl = candidates.get(i);
				}
			}
		}
		
		return dupl;
	}

	@Override
	public List<Collection<KIMEntity>> getDuplicateClus() {
		return null;
	}

	private class DuplicateResult {
		private boolean isDuplicate = false;
		private double similary = 0;
	}
}
