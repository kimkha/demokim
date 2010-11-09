package FrameWork;

import java.io.File;
import java.util.List;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;

import tool.KIMAPI;

import model.KIMEntity;

public class CandidateDefinitionImpl implements CandidateDefinition{
	File candidateDefFile = null;
	@Override
	public List<URI> listCandidate(KIMEntity e) {
		// Truy van cac thuc the can kiem tra.
		if(candidateDefFile == null){
			// truy van cac thuc the cung lop
			Resource kimClass = e.getKIMClass().res;
			List<URI> listcan = KIMAPI.getAllEntityInClass(kimClass);
			return listcan;
		}
		return null;
	}

	@Override
	public void setCandidateDefFile(File f) {
		// TODO Auto-generated method stub
		
	}

}
