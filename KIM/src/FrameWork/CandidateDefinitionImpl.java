package FrameWork;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openrdf.model.Resource;
import org.openrdf.model.URI;

import tool.KIMAPI;
import model.CanDefPolicy;
import model.KIMClass;
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
	@SuppressWarnings("unchecked")
	@Override
	public List<URI> listCandidate(KIMEntity e) {
		// Truy van cac thuc the can kiem tra.
		List<KIMClass> kimclasses = e.getKIMClass();
		if(canDefPo == null){
			// truy van cac thuc the cung lop
			List<URI> listcan = new ArrayList<URI>();
			for(KIMClass c : kimclasses){
				listcan.addAll((Collection<URI>) KIMAPI.getAllEntityURIInClass(c.res));
			}
			return listcan;
		}else{
			List<URI> listcan = new ArrayList<URI>();
			for(KIMClass c : kimclasses){
				List<URI> clazz = canDefPo.getRelateClass(c);
				for(URI u : clazz){
					listcan.addAll((Collection<URI>) KIMAPI.getAllEntityURIInClass(u));
				}
			}
			return listcan;
		}
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
