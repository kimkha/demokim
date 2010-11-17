package FrameWork;

import java.io.File;
import java.util.List;
import java.util.Map;

import model.Description;
import model.DupDefPolicy;

import model.KIMEntity;


public interface DuplicateDefinition {
	public void setDupDefFile(File f);
	public void setDupDefPolicy(DupDefPolicy d);
	public List<Description> getElementDescription(KIMEntity e);
	public List<Description> getRelationDescription(KIMEntity e);
	public Map<String, Description> getMapEleDescription(KIMEntity e);
	public Map<String, Description> getMapRelaDescription(KIMEntity e);
}