package FrameWork;

import java.util.Collection;
import java.util.List;

import model.KIMEntity;

public interface DuplicateDetection {
	public KIMEntity getDuplicate(KIMEntity e);
	public List<Collection<KIMEntity>> getDuplicateClus();
}
