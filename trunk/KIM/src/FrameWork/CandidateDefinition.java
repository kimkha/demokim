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
	public void getKIMClass(List<URI> classlist);
	public boolean hasNext();
	public List<URI> next();
	public int getStatus();
}
