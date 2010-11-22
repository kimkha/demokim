package hcmut.kim.FrameWork;

import hcmut.kim.model.CanDefPolicy;
import hcmut.kim.model.KIMClass;
import hcmut.kim.model.KIMEntity;

import java.io.File;
import java.util.List;

import org.openrdf.model.URI;


public interface CandidateDefinition {
	public void setCandidateDefFile(File f);
	public List<URI> listCandidate(KIMEntity e); // For add new Entity
	public List<URI> listCandidate(); // For checking in KB
	public List<URI> listCandidate(KIMClass c);
	public List<URI> listCandidate(CanDefPolicy candef);
}
