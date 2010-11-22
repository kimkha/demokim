package tool.parser;

import java.io.File;
import java.io.InputStream;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class RDFFile {
	private File file = null;
	private OntModel model = null;
	private ExtendedIterator<Ontology> list;
	
	public RDFFile(String filename) {
        try {
        	file = new File(filename);
        	if (file.exists()) {
            	model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
            	InputStream in = FileManager.get().open(filename);
            	model.read(in, null);
            	list = model.listOntologies();
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RDFNode item = list.toList().get(0);
		item.toString();
	}
}
