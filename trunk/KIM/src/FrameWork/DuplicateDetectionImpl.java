package FrameWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openrdf.model.URI;

import tool.DuplicateAPI;
import tool.KIMAPI;

import model.KIMEntity;

public class DuplicateDetectionImpl implements DuplicateDetection{
	
	private CandidateDefinition candef  = null;
	private DuplicateDefinition dupdef  = null;
	private double valueThreshold; // for string
	private double simThreshold; // for entity
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
	public KIMEntity getDuplicate(KIMEntity e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Set<KIMEntity>> getDuplicateClus() {
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
	public boolean isDuplicate(KIMEntity e1, KIMEntity e2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
