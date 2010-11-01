package tool;

import java.util.Collection;
import java.util.Iterator;

import org.openrdf.model.Literal;

import com.ontotext.kim.client.entity.EntityDescription;

public class Description {
	public static void show(EntityDescription e){
		int type = 0;
		show(e, type);
	}
	public static void show(EntityDescription e, int type){
		if(type == 0){
			e.getAttributeTypes();
			e.getContextTypes();
			e.getLabels();
			e.getPrefetchedRelationTypes();
			e.getRelationTypes();
		}
	}
	
	public static void show(Collection c, int type){
		Iterator it = c.iterator();
		while(it.hasNext()){
			Object ob = it.next();
			System.out.println(ob);
			System.out.println("++++++++");
		}
	}
	public static void show(Collection<Literal> c) {
		Iterator it = c.iterator();
		while(it.hasNext()){
			Object ob = it.next();
			System.out.println(ob);
			System.out.println("++++++++");
		}
		
	}
}
