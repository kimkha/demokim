package FrameWork;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
	
	
	private boolean isDuplicate(KIMEntity e1, KIMEntity e2){
		return false;
	}
	
	
	@Override
	public KIMEntity getDuplicate(KIMEntity e) {
		// liet ke tat ca thuc the can so sanh -- candef.listCandidate(e)
		// so sanh tung cap thuc the -- isDuplicate(KIMEntity e1, KIMEntity e2);
		// tim ra thuc the trung lap voi  thuc the da cho
		
		return null;
	}

	@Override
	public List<Collection<KIMEntity>> getDuplicateClus() {
		return null;
	}

}
