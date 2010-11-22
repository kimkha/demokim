package hcmut.kim.FrameWork;

import hcmut.kim.model.KIMEntity;

import java.util.Set;


public interface DataFusion {
	public KIMEntity merge(KIMEntity e1, KIMEntity e2);
	public KIMEntity merge(Set<KIMEntity> list);
}