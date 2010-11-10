package FrameWork;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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
			List<URI> listcan = new ArrayList();
			Iterator<URI> itcan = KIMAPI.getAllEntityURIInClass(kimClass);
			while(itcan.hasNext()){
				listcan.add(itcan.next());
			}
			return listcan;
		}
		return null;
	}
	
	public List<URI> listCandidate(){
		return null;
	}

	@Override
	public void setCandidateDefFile(File f) {
		this.candidateDefFile = f;
		
	}

}
