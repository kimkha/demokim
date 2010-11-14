package tool.parser;

import java.io.File;
import java.io.InputStream;

import org.w3c.dom.Document;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;

public class RDFFile {
	private File file = null;
	private Model model = null;
	private NodeIterator list;
	
	public RDFFile(String filename) {
        try {
        	file = new File(filename);
        	if (file.exists()) {
            	model = ModelFactory.createDefaultModel();
            	InputStream in = FileManager.get().open(filename);
            	model.read(in, null);
            	list = model.listObjects();
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RDFNode item = list.toList().get(0);
		item.toString();
	}
}
