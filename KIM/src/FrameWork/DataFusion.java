package FrameWork;

import java.util.Set;

import model.KIMEntity;

public interface DataFusion {
	public KIMEntity merge(KIMEntity e1, KIMEntity e2);
	public KIMEntity merge(Set<KIMEntity> list);
}