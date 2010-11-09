package FrameWork;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.openrdf.model.Graph;
import org.openrdf.model.Statement;

import model.DupDefPolicy;
import model.KIMEntity;

public class DuplicateDefinitionImpl implements DuplicateDefinition{

	private File dupDefFile = null;
	@Override
	public Map<String,String> getDescription(KIMEntity e) {
		Map<String, String> map = new TreeMap<String, String>();
		if(dupDefFile == null){
			Graph graph = e.entdes.toRDF();
			Iterator<Statement> stas = graph.iterator();
			while(stas.hasNext()){
				Statement s = stas.next();
				map.put(s.getPredicate().getLocalName(), s.getObject().stringValue());
			}
			return map;
		}
		return null;
	}

	@Override
	public void setDupDefFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDupDefPolicy(DupDefPolicy d) {
		// TODO Auto-generated method stub
		
	}
	

}
