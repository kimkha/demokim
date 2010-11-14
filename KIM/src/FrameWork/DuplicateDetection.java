package FrameWork;

import java.util.Collection;
import java.util.Set;
import java.util.List;

import model.KIMEntity;

public interface DuplicateDetection {
	public KIMEntity getDuplicate(KIMEntity e);
	public KIMEntity findDuplicate(KIMEntity e, Set<KIMEntity> setEntity);
	public Set<KIMEntity> findDuplicates(KIMEntity e, Set<KIMEntity> setEntity);
	public List<Set<KIMEntity>> getDuplicateClus();
	public List<Set<KIMEntity>> getDuplicateClus(List<KIMEntity> liste1, List<KIMEntity> liste2);
	public boolean isDuplicate(KIMEntity e1, KIMEntity e2);
}
