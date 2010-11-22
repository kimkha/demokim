package FrameWork;

import java.util.List;
import java.util.Set;

import model.KIMEntity;

public interface DuplicateDetection {
	public KIMEntity getDuplicate(KIMEntity e);
	public KIMEntity findDuplicate(KIMEntity e, Set<KIMEntity> setEntity);
	public Set<KIMEntity> findDuplicates(KIMEntity e, Set<KIMEntity> setEntity);
	public List<Set<KIMEntity>> getDuplicateClus();
	public List<Set<KIMEntity>> getDuplicateClus(List<KIMEntity> liste1, List<KIMEntity> liste2);
	public boolean isDuplicate(KIMEntity e1, KIMEntity e2);
	public double getSimilarity(KIMEntity e1, KIMEntity e2);
	
	public void setValueThreshold(double valueThreshold);
	public double getValueThreshold();
	public void setSimThreshold(double simThreshold);
	public double getSimThreshold();
	
	public void setCandef(CandidateDefinition candef);
	public CandidateDefinition getCandef();
	public void setDupdef(DuplicateDefinition dupdef);
	public DuplicateDefinition getDupdef();
}
