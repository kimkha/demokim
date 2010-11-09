package FrameWork;

import java.io.File;
import java.util.List;

import org.openrdf.model.URI;

import model.KIMEntity;

public interface CandidateDefinition {
	public void setCandidateDefFile(File f);
	public List<URI> listCandidate(KIMEntity e);
}
