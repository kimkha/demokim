package FrameWork;

import java.io.File;
import java.util.Map;

import model.DupDefPolicy;
import model.KIMEntity;
public interface DuplicateDefinition {
	public void setDupDefFile(File f);
	public void setDupDefPolicy(DupDefPolicy d);
	public Map<String,String> getDescription(KIMEntity e);
	
}