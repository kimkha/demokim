package FrameWork;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;

import tool.KIMAPI;
import model.CanDefPolicy;
import model.KIMEntity;

public class CandidateDefinitionImpl implements CandidateDefinition{
	CanDefPolicy canDefPo = null;
	List<List<URI>> listCandidate = null;
	private int status;
	public CandidateDefinitionImpl(int status){
		this.status = status;
		if(status == 1){
			listCandidate = new ArrayList<List<URI>>();
		}
	}
	@Override
	public List<URI> listCandidate(KIMEntity e) {
		// Truy van cac thuc the can kiem tra.
		if(canDefPo == null){
			// truy van cac thuc the cung lop
		
			Resource kimClass = e.getKIMClass().res;
			List<URI> listcan = new ArrayList<URI>();
			Iterator<URI> itcan = KIMAPI.getAllEntityURIInClass(kimClass);
			while(itcan.hasNext()){
				listcan.add(itcan.next());
			}
			return listcan;
		}else{
			
		}
		return null;
	}
	
	public List<URI> listCandidate(){
		return null;
	}

	@Override
	public void setCandidateDefFile(File f) {
		canDefPo = new CanDefPolicy(f);	
	}


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<URI> next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getKIMClass(List<URI> classlist) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}

}
