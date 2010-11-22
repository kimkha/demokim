package hcmut.kim.FrameWork;

import hcmut.kim.model.Description;
import hcmut.kim.model.DupDefPolicy;
import hcmut.kim.model.KIMEntity;

import java.io.File;
import java.util.List;
import java.util.Map;




public interface DuplicateDefinition {
	public void setDupDefFile(File f);
	public void setDupDefPolicy(DupDefPolicy d);
	public List<Description> getElementDescription(KIMEntity e);
	public List<Description> getRelationDescription(KIMEntity e);
	public Map<String, Description> getMapEleDescription(KIMEntity e);
	public Map<String, Description> getMapRelaDescription(KIMEntity e);
}