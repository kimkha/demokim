package FrameWork;

import java.io.File;
import java.util.List;
import java.util.Map;

import model.Description;
import model.DupDefPolicy;
import model.ElementDescription;
import model.KIMEntity;
import model.RelationDescription;

public interface DuplicateDefinition {
	public void setDupDefFile(File f);
	public void setDupDefPolicy(DupDefPolicy d);
	public List<Description> getDescription(KIMEntity e);
	public List<ElementDescription> getElementDescription(KIMEntity e);
	public List<RelationDescription> getRelationDescription(KIMEntity e);
}