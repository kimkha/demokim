package FrameWork;

import java.util.Set;
import java.util.List;

import model.KIMEntity;

public interface DuplicateDetection {
	public KIMEntity getDuplicate(KIMEntity e);
	public List<Set<KIMEntity>> getDuplicateClus();
	public boolean isDuplicate(KIMEntity e1, KIMEntity e2);
}
