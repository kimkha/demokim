package model;

import org.openrdf.model.Resource;

public abstract class KIMResource implements Resource{
	public Resource res;
	public boolean isExtracted;
	public abstract void extract();
}
