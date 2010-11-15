package FrameWork;

import java.io.File;
import java.util.List;

import org.openrdf.model.URI;

import model.CanDefPolicy;
import model.KIMClass;
import model.KIMEntity;

public interface CandidateDefinition {
	public void setCandidateDefFile(File f);
	public List<URI> listCandidate(KIMEntity e); // For add new Entity
	public List<URI> listCandidate(); // For checking in KB
	public List<URI> listCandidate(KIMClass c);
	public List<URI> listCandidate(CanDefPolicy candef);
}
